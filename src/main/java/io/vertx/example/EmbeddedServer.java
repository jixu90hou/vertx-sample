package io.vertx.example;

import io.vertx.core.Vertx;

/**
 * Created by jackshen on 2017/9/3.
 */
public class EmbeddedServer {
    public static void main(String[] args) {
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!!!")).listen(9001);
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!!!")).listen(9002);
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!!!")).listen(9003);
        Vertx.vertx().createHttpServer().requestHandler(req -> req.response().end("Hello World!!!")).listen(9004);

    }
}
