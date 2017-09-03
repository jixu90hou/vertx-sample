package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.util.Runner;

/**
 * Created by jackshen on 2017/9/3.
 */
public class SslClient extends AbstractVerticle {
    public static void main(String[] args) {
        Runner.runExample(SslClient.class);
    }

    @Override
    public void start() throws Exception {
        vertx.createHttpClient(new HttpClientOptions()
                .setSsl(true).setTrustAll(true))
                .getNow(9000, "localhost", "/", resp -> {
                    System.out.println("Go response " + resp.statusCode());
                    resp.bodyHandler(body -> System.out.println("Go data " + body.toString("utf-8")));
                });
    }
}
