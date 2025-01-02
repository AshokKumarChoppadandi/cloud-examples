package io.github.ashokkumarchoppadandi.s3;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;

public class S3BucketCRUDOperations {

    private S3Client s3Client;

    public S3BucketCRUDOperations(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public CreateBucketRequest createBucketRequest(String bucketName) {
        return null;
    }

    public CreateBucketResponse createBucket(String bucketName) {
        CreateBucketRequest request = createBucketRequest(bucketName);
        return null;
    }

}
