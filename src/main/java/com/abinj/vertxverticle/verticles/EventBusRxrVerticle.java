package com.abinj.vertxverticle.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventBusRxrVerticle extends AbstractVerticle {
    private String name;
    private Logger logger = LoggerFactory.getLogger(EventBusRxrVerticle.class);

    public EventBusRxrVerticle(String name) {
        this.name = name;
    }

    @Override
    public void start(Future<Void> startFuture) {
        vertx.eventBus().consumer("receiver", message -> {
            logger.info("Verticle: " + name + "message body--->" + message.body());
        });
    }
}
