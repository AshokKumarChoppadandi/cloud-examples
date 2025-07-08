package io.github.ashokkumarchoppadandi.s3;

import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.util.List;

public class ListS3Buckets {
    public static void main(String[] args) {
        String ACCESS_KEY = System.getenv("AWS_ACCESS_KEY_ID");
        String SECRET_KEY = System.getenv("AWS_SECRET_ACCESS_KEY");
        String SESSION_TOKEN = System.getenv("AWS_SESSION_TOKEN");

        if (ACCESS_KEY == null || SECRET_KEY == null || SESSION_TOKEN == null) {
            throw new IllegalArgumentException("AWS keys not set in Environment variables");
        }

        AwsSessionCredentials credentials = AwsSessionCredentials.create(ACCESS_KEY, SECRET_KEY, SESSION_TOKEN);
        ListBucketsResponse bucketsList;

        try (S3Client s3Client = S3Client
                .builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build()) {

            bucketsList = s3Client.listBuckets();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(!bucketsList.hasBuckets()) {
            System.out.println("No S3 buckets found");
        }

        List<Bucket> buckets = bucketsList.buckets();

        System.out.println("Total Number of S3 buckets - " + buckets.size());
        System.out.println("Buckets List:\n--------------------");

        buckets.forEach(x -> System.out.println(x.name()));
    }
}
