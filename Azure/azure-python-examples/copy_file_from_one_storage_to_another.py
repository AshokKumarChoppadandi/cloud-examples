import os
import sys

from azure.storage.blob import BlobServiceClient
from azure.core.exceptions import ResourceNotFoundError
from azure.identity import ClientSecretCredential


def get_credentials():
    client_id = os.environ.get('CLIENT_ID')
    tenant_id = os.environ.get('TENANT_ID')
    client_secret = os.environ.get('CLIENT_SECRET')

    credential = ClientSecretCredential(tenant_id, client_id, client_secret)
    return credential


def get_blob_service_client(account_url):
    credential = get_credentials()
    blob_service_client = BlobServiceClient(account_url, credential=credential)
    return blob_service_client


def copy_between_storage_accounts(source_account_url: str, destination_account_url: str, source_container_name: str, destination_container_name: str):
    global blob_name
    source_blob_service_client = get_blob_service_client(source_account_url)
    destination_blob_service_client = get_blob_service_client(destination_account_url)
    print("Source and destination blobs service clients created successfully")

    source_container_client = source_blob_service_client.get_container_client(container=source_container_name)
    destination_container_client = destination_blob_service_client.get_container_client(
        container=destination_container_name)
    print("Source and destination container clients created successfully")

    try:
        print("Listing blobs in source container")
        blobs = source_container_client.list_blobs()

        for blob in blobs:
            print("Inside for loop")
            blob_name = blob.name
            print(f"Blob - {blob_name}")
            source_blob = source_container_client.get_blob_client(blob_name)
            # source_url = source_blob.url
            # print(f"Blob URL - {source_url}")
            destination_blob = destination_container_client.get_blob_client(blob_name)
            print(f"Copying blob: {blob_name}")

            # destination_blob.start_copy_from_url(source_url)
            source_data = source_blob.download_blob()
            destination_blob.upload_blob(source_data.readall(), overwrite=True)
            print(f"File {blob_name} copied from {source_container_name} to {destination_container_name}")

        print("Copy successful")
    except ResourceNotFoundError:
        print(f"File {blob_name} not found in {source_container_name}")


if __name__ == '__main__':
    src_account_url = sys.argv[1]
    dest_account_url = sys.argv[2]
    src_container_name = sys.argv[3]
    dest_container_name = sys.argv[4]

    copy_between_storage_accounts(src_account_url, dest_account_url, src_container_name, dest_container_name)
