### ACID Properties

- **Atomicity**: When you purchase an item online, say a shirt and a pair of pants, atomicity ensures either both items get added to your order, or none at all. You wouldn't want to pay for a shirt and pants, and only find out the pants aren't available after your card has been charged.
- **Consistency**: This is like the rules of the store - for example, an item that's out of stock should not be allowed to be added to the cart. The database ensures these rules are always followed.
- **Isolation**: Imagine many customers are shopping at the same time. Isolation ensures your shopping doesn't affect anyone else's and vice versa. You won't suddenly see someone else's items in your cart!
- **Durability**: Once you've placed an order, it's there to stay. Even if the site crashes or there's a power cut, your order should still be there when things are back to normal.

### CAP Theorem

The CAP theorem, also known as Brewer's theorem, is a fundamental principle that applies to distributed systems. This theorem posits that it's impossible for a distributed data store to simultaneously provide more than two out of the following three guarantees: Consistency, Availability, and Partition Tolerance.

- **Consistency** in this context means that every read from the database receives the most recent write or an error. In a consistent system, any transaction will bring the database from one valid state to another, maintaining the 'global' order of transactions.
- **Availability** is about ensuring that every request receives a response, without the guarantee that it contains the most recent write. In an available system, the database will always respond to a request (though it may not be the most up-to-date response), and it's designed to ensure uninterrupted service.
- **Partition Tolerance** refers to the system's ability to continue to operate despite arbitrary partitioning due to network failures. In a partition-tolerant system, the database can be split over multiple servers, and in case of a network failure, it can continue to function even if one or more of the servers are not communicating with the others.

The CAP theorem is significant because it illustrates the tradeoffs that developers must consider when designing distributed systems. They must choose two of these three options to prioritize, and this choice can greatly impact the system's reliability, performance, and overall behavior.

CA: The system prioritizes consistency and availability but doesn't handle network partitions well. In the case of a network partition, it might choose to become unavailable to maintain consistency.

CP: The system prioritizes consistency and partition tolerance but sacrifices availability. In the face of a network partition, it will maintain consistency by refusing some requests.

AP: The system prioritizes availability and partition tolerance but sacrifices strong consistency. It continues to operate and respond to requests even if it means returning stale data or data that is not consistent across all nodes.

### SOLID Principles

The SOLID principles are a set of five principles for designing and organizing code that makes it more understandable, flexible, and maintainable. They are as follows:

- **Single-Responsibility Principle** (SRP): This principle states that a class should have only one responsibility or reason to change. For example, a `Customer` class should only manage information related to a customer and should not be responsible for implementing business rules related to orders.
- **Open-Closed Principle** (OCP): The Open-Closed Principle states that classes should be open for extension but closed for modification. In other words, you should be able to add new functionality to a class without changing its existing code. In Java, this can be achieved using interfaces and abstract classes.
- **Liskov Substitution Principle** (LSP): This principle states that subclasses should be substitutable for their base classes without causing errors. If a method expects an instance of a base class, it should be able to work with an instance of any subclass without knowing it.
- **Interface Segregation Principle** (ISP): This principle states that a class should not be forced to implement interfaces it does not use. Instead of one large interface, it is better to have many smaller, more specific interfaces.
- **Dependency Inversion Principle** (DIP): The Dependency Inversion Principle states that high-level modules should not depend on low-level modules. Both should depend on abstractions. In Java, this can be achieved by using interfaces or abstract classes, and using dependency injection to provide the concrete implementation.

# JAVA 8 Features

- Lambda expressions
- Interface
    - Default methods
    - static methods
- forEach
- Functional Interface
- Stream API
- Optional Class
- java.time API

## OOP Principles

- Encapsulation
    - Hiding the details and unnecessary implementation details from the outside world
    - Restrict the modification of the properties of the object
    - Scope modifiers like public, private, protected, default
- Inheritance
    - Inherit the parent properties and methods to the child classes
    - It helps reuability of the code
- Polimorphism
    - Using same name execute different code
    - Compile time and Runtime polymorphism
    - Override(Runtime) and overload(Compile time) of the methods
- Abstraction
    - Interfaces and Abstract methods
    - Abstract the implementation details of the class and methods

## Thread States

- NEW (instance created but not yet started)
- RUNNABLE (start() method called. executing code in the jvm or waiting for processor)
- BLOCKED (waiting for lock)
- WAITING (join(), wait() with no time specified)
- TIMED_WAITING (sleep(), join(), wait() with time specified)
- TERMINATED (execution completed)
