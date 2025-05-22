import os
from azure.identity import ClientSecretCredential
from azure.storage.blob import BlobServiceClient


def list_blob_containers():
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
    blob_service_client = BlobServiceClient(account_url, credential=credential)
    print("Containers...")
    containers = blob_service_client.list_containers()

    for container in containers:
        print(f"Container: {container.name}")


if __name__ == '__main__':
    list_blob_containers()
