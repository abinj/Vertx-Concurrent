package com.abinj.vertxverticle.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class EventbusSenderVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) {
        vertx.eventBus().publish("receiver", "Message publish");
        vertx.eventBus().send("receiver", "Message send");
    }
}
