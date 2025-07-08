package io.github.ashokkumarchoppadandi.s3;

import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Bucket;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CheckS3Bucket {
    public static void main(String[] args) {
        String ACCESS_KEY = System.getenv("AWS_ACCESS_KEY_ID");
        String SECRET_KEY = System.getenv("AWS_SECRET_ACCESS_KEY");
        String SESSION_TOKEN = System.getenv("AWS_SESSION_TOKEN");

        String s3BucketName = args[0];
        Bucket bucket = Bucket.builder().name(s3BucketName).build();

        AwsSessionCredentials sessionCredentials = AwsSessionCredentials.create(
                ACCESS_KEY,
                SECRET_KEY,
                SESSION_TOKEN
        );

        ListBucketsResponse bucketsResponse;
        try (S3Client s3Client = S3Client
                .builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(sessionCredentials))
                .build()) {

            bucketsResponse = s3Client.listBuckets();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!bucketsResponse.hasBuckets()) {
            System.out.println("No S3 buckets found");
        }

        List<Bucket> buckets = bucketsResponse.buckets();
        List<String> bucketNames = buckets.stream().map(Bucket::name).collect(Collectors.toList());
        if (bucketNames.contains(s3BucketName)) {
            System.out.println("Bucket exists");
            buckets
                    .stream()
                    .filter(x -> x.name().equals(s3BucketName))
                    .forEach(x -> System.out.println("Bucket Name - " + x + ", created on - " + x.creationDate()));
        } else {
            System.out.println("S3 bucket with name '" + s3BucketName + "' doesn't exists!");
        }
    }
}
