package io.github.ashokkumarchoppadandi.utils;

import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.utility.DockerImageName;

public class EmbeddableLocalStackContainer extends LocalStackContainer {
    /*
    public static DockerImageName getDockerImage (String dockerImageName) {
        return DockerImageName.parse(dockerImageName);
    }
    */

    // public String dockerImage;
    // public LocalStackContainer container;

    public static String dockerImage = "localstack/localstack:latest";
    public static DockerImageName dockerImageName = DockerImageName.parse(dockerImage);
    public static LocalStackContainer localStackContainer;

    public EmbeddableLocalStackContainer(String dockerImage) {
        super(dockerImage);
    }

    public static LocalStackContainer getInstance() {
        if (localStackContainer == null) {
            localStackContainer = new LocalStackContainer(dockerImageName)
                    .withServices(Service.S3, Service.EC2);
        }

        if (!localStackContainer.isRunning()) {
            localStackContainer.start();
        }

        return localStackContainer;
    }
}
