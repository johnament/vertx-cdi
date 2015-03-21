Several things happening in this directory.

1. SEBooter - the main entry point for the application.  Initializes weld.

2. CDIVerticle - basic CDI implementation of a verticle, handling start/stop options.  Shows that the injected Vert.x
instance and the param on start up are the same.

3. VertxLauncher - a CDI component that starts up a Vert.x server.  Iterates through all discovered Verticles and registers them.

4. HTTPLauncher - a basic demonstration that a HTTPService starts and can respond on 8080.