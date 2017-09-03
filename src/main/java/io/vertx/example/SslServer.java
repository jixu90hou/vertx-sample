package io.vertx.example;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;
import io.vertx.util.Runner;

/**
 * Created by jackshen on 2017/9/3.
 */
public class SslServer extends AbstractVerticle {
    public static void main(String[] args) {
        Runner.runExample(SslServer.class);
    }

    @Override
    public void start() {
        HttpServer server = vertx.
                createHttpServer(new HttpServerOptions()
                        .setSsl(true).setKeyStoreOptions(new JksOptions()
                                .setPath("server-keystore.jks").setPassword("wibble")));
        String html="<html><body><h1>Hello from vert.x!!!</h1></body></html>";
        server.requestHandler(req->{
            System.out.println(req.getParam("aaa"));
            req.response().putHeader("content-type","text/html").end(html);
        }).listen(9000);
    }
}
