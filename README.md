# Vertx-Concurrent
Vert.x:- Eclipse Vert.x is a tool-kit for building reactive applications on the JVM.

# Verticle:-
Verticles are chunks of code that get deployed and run by Vert.x. 
A Vert.x instance maintains N event loop threads (where N by default is core*2) by default.
Verticles can be written in any of the languages that Vert.x supports and a single application can include verticles written in multiple languages.
You can think of a verticle as a bit like an actor in the Actor Model.

# The Golden Rule - Don’t Block the Event Loop
We already know that the Vert.x APIs are non blocking and won’t block the event loop, but that’s not much help if you block the event loop yourself in a handler.

If you do that, then that event loop will not be able to do anything else while it’s blocked.
If you block all of the event loops in Vertx instance then your application will grind to a complete halt!

# Reactor and Multi Reactor
In a standard reactor implementation there is a single event loop thread which runs around in a loop delivering all events to all handlers as they arrive.
The trouble with a single thread is it can only run on a single core at any one time,
so if you want your single threaded reactor application (e.g. your Node.js application) to scale over your multi-core server you have to start up and manage many different processes.

Vert.x works differently here. Instead of a single event loop, each Vertx instance maintains several event loops.
By default we choose the number based on the number of available cores on the machine, but this can be overridden.
This means a single Vertx process can scale across your server, unlike Node.js.
We call this pattern the Multi-Reactor Pattern to distinguish it from the single threaded reactor pattern.

# Points to Remember
1) Each class can be make it into a verticle by extends with AbstractVerticle class.
2) Publish(), this method sends messages to all verticles listening on a given address.
3) Send(), this method just sends message to any one listening verticle.
4) Vert.x distribute message based on non-strict round robin algorithm.
5)
