/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 *     distributed with this work for additional information
 *     regarding copyright ownership.  The ASF licenses this file
 *     to you under the Apache License, Version 2.0 (the
 *     "License"); you may not use this file except in compliance
 *     with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing,
 *     software distributed under the License is distributed on an
 *     "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *     KIND, either express or implied.  See the License for the
 *     specific language governing permissions and limitations
 *     under the License.
 */

package com.tad.vertx;

import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by johnament on 3/21/15.
 */
@ApplicationScoped
public class VertxLauncher {
    private Vertx vertx;

    @Inject
    @Any
    private Instance<Verticle> allDiscoveredVerticles;

    public void initVertx(@Observes @Initialized(ApplicationScoped.class) Object obj) {
        this.vertx = Vertx.vertx();

        allDiscoveredVerticles.forEach(v -> {
            System.out.println("Found verticle "+v);
            vertx.deployVerticle(v);
        });
    }

    @Produces
    @ApplicationScoped
    public Vertx getVertx() {
        return vertx;
    }

    @PreDestroy
    public void shutdown() {
        this.vertx.close();
    }
}
