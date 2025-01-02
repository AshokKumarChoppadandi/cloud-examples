package io.github.ashokkumarchoppadandi.s3;

import io.github.ashokkumarchoppadandi.utils.EmbeddedLocalstackContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class S3BucketCRUDOperationsTest extends EmbeddedLocalstackContainer {

    @BeforeAll
    public static void initialiseS3Client () {
        System.out.println("Initialising S3 Client");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("Cleaning up environment");
    }

    @Test
    public void simpleTest() {
        System.out.println(localStackContainer.getEndpoint().toString());
        assertEquals(1, 1);

    }

}
