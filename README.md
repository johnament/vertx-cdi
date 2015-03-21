# Simple Demo of CDI w/ Vert.x

http://vertx.io/ for information on Vert.x

http://weld.cdi-spec.org/ for information on Weld

The idea here is to demonstrate interoperability between a DI platform (CDI/Weld) and Vert.x, a reactive framework.

Several ideas are pitched here.

- Launching Vert.x within a CDI component.
- Managing Vert.x verticles as CDI Managed Beans
- Bridging CDI Events and Vert.x Events