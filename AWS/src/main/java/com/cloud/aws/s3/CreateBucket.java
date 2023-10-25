package com.cloud.aws.s3;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;

public class CreateBucket {
    public static final String AWS_ACCESS_KEY = System.getenv("AWS_ACCESS_KEY");
    public static final String AWS_SECRET_KEY = System.getenv("AWS_SECRET_KEY");

    public static void main(String[] args) {
        String bucketName = args[0];

        AwsCredentials credentials = AwsBasicCredentials.create(AWS_ACCESS_KEY, AWS_SECRET_KEY);

        S3Client s3Client = S3Client
                .builder()
                .region(Region.AP_SOUTH_1)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        CreateBucketRequest request = CreateBucketRequest
                .builder()
                .bucket(bucketName)
                .build();

        CreateBucketResponse response = s3Client.createBucket(request);

        System.out.println("Response: " + response.toString());
    }
}
