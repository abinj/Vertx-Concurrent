package com.abinj.vertxverticle.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class EventBusRxrVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> startFuture) {
        vertx.eventBus().consumer("receiver", message -> {
            System.out.println("Received message body= " + message.body());
        });
    }
}
