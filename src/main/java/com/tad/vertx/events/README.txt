The example in this folder shows bridging CDI Events and the Vert.x Event Bus.

There are two produces here.  One is every 1s sends a text message.  The other, every 1.5s sends a JSON object.

By running this, you'll get simple system output showing every invocation, one calling a string CDI observer the other
calling a JsonObject observer print out, with the ID of the periodic included.