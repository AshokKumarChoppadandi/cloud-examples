from azure.storage.blob import BlobServiceClient
import os


def read_files_from_storage_account_with_sas():
    try:
        source_storage_account_url = os.environ.get('SOURCE_STORAGE_ACCOUNT_URL')
        destination_storage_account_url = os.environ.get('DESTINATION_STORAGE_ACCOUNT_URL')
        source_container_name = os.environ.get('SOURCE_CONTAINER_NAME')
        destination_container_name = os.environ.get('DESTINATION_CONTAINER_NAME')

        source_blob_service_client = BlobServiceClient(account_url=source_storage_account_url)
        destination_blob_service_client = BlobServiceClient(account_url=destination_storage_account_url)

        source_container_client = source_blob_service_client.get_container_client(source_container_name)
        destination_container_client = destination_blob_service_client.get_container_client(destination_container_name)

        blob_list = source_container_client.list_blobs()

        for blob in blob_list:
            source_blob = source_container_client.get_blob_client(blob.name)
            destination_blob = destination_container_client.get_blob_client(blob.name)

            destination_blob.start_copy_from_url(source_blob.url)
            print(f"File {blob.name} copied from {source_container_name} to {destination_container_name}")
    except Exception as e:
        print(f"An error occurred: {str(e)}")


if __name__ == '__main__':
    read_files_from_storage_account_with_sas()
