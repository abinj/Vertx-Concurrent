package com.abinj.vertxverticle.application;

import com.abinj.vertxverticle.verticles.EventBusRxrVerticle;
import com.abinj.vertxverticle.verticles.SimpleVerticle;
import io.vertx.core.Vertx;

public class ApplicationRunner {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new SimpleVerticle());
        vertx.deployVerticle(new EventBusRxrVerticle());
    }
}
