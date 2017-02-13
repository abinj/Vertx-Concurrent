package com.abinj.vertxverticle.verticles;

import io.vertx.core.AbstractVerticle;

public class SimpleVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        String name = config().getString("name", "World");
        vertx.createHttpServer().requestHandler(httpServerRequest -> httpServerRequest.response()
                .end("Hello" + name + "!!!")).listen(8080);
    }




    public void onStop() {
        vertx.close();
    }
}
