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

import io.vertx.core.Context;
import io.vertx.core.Future;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;

import javax.inject.Inject;

/**
 * Created by johnament on 3/21/15.
 */
public abstract class CDIVerticle implements Verticle{
    @Inject
    private Vertx vertx;

    @Override
    public Vertx getVertx() {
        return vertx;
    }

    @Override
    public void init(Vertx vertx, Context context) {
        System.out.println("Injected vertx "+this.vertx);
        System.out.println("Param vertx "+vertx);
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        onVertxStart();
        startFuture.complete();
    }

    @Override
    public void stop(Future<Void> stopFuture) throws Exception {
        onVertxStop();
        stopFuture.complete();
    }

    /**
     * CDI runtimes should override this method if they want to observe when Vertx starts.
     * They should use a @PostConstruct method or observe Initialized App Scoped if they want to watch when CDI container starts
     */
    protected void onVertxStart() {

    }

    /**
     * Signalled when the vertx service stops for this verticle.
     */
    protected void onVertxStop() {

    }
}
