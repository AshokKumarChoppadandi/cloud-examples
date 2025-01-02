package io.github.ashokkumarchoppadandi.utils;

import org.testcontainers.containers.localstack.LocalStackContainer;

public class EmbeddedLocalstackContainer {
    public static LocalStackContainer localStackContainer = EmbeddableLocalStackContainer.getInstance();
}
