import os
import sys

from azure.storage.blob import BlobServiceClient, BlobClient
from azure.identity import ClientSecretCredential


def get_credentials():
    client_id = os.environ.get('CLIENT_ID')
    tenant_id = os.environ.get('TENANT_ID')
    client_secret = os.environ.get('CLIENT_SECRET')
    subscription_id = os.environ.get('SUBSCRIPTION_ID')
    account_url = os.environ.get('STORAGE_URL')
    print(f"Client ID: {client_id}")
    print(f"Tenant ID: {tenant_id}")
    print(f"Client Secret: {client_secret}")
    print(f"Subscription ID: {subscription_id}")
    print(f"Account URL: {account_url}")

    credential = ClientSecretCredential(tenant_id, client_id, client_secret)
    return credential, account_url


def get_blob_service_client():
    credential, account_url = get_credentials()
    blob_service_client = BlobServiceClient(account_url, credential=credential)
    return blob_service_client


def upload_file(source_file_path: str, destination_file_name: str, container_name: str):
    local_file_name = source_file_path
    blob_name = destination_file_name

    blob_service_client = get_blob_service_client()
    container_client = blob_service_client.get_container_client(container=container_name)
    blob_client = container_client.get_blob_client(blob=blob_name)

    with open(local_file_name, "rb") as data:
        blob_client.upload_blob(data, overwrite=True)

    print(f"File {local_file_name} uploaded to blob storage as {blob_name}")


if __name__ == '__main__':
    src_file_path = sys.argv[1]
    dest_file_name = sys.argv[2]
    storage_container_name = sys.argv[3]
    upload_file(src_file_path, dest_file_name, storage_container_name)
