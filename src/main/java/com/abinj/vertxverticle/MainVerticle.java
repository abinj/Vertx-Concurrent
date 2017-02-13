package com.abinj.vertxverticle;

import io.vertx.core.AbstractVerticle;

/**
 * Created by dxuser on 7/2/17.
 */
public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        String name = config().getString("name", "World");
        vertx.createHttpServer().requestHandler(httpServerRequest -> httpServerRequest.response()
                .end("Hello" + name + "!!!")).listen(8080);
    }
}
