## The SOLID principles are a set of five principles for designing and organizing code that makes it more understandable, flexible, and maintainable. They are as follows:

**Single-Responsibility Principle** (SRP): This principle states that a class should have only one responsibility or reason to change. For example, a `Customer` class should only manage information related to a customer and should not be responsible for implementing business rules related to orders.
  ```
  //One class does many jobs.
  class UserService {
    void validateUser() {}
    void saveUser() {}
    void sendEmail() {}
  }

  //solution
  class UserValidator {}
  class UserRepository {}
  class EmailService {}
  ```
**Open-Closed Principle** (OCP): The Open-Closed Principle states that classes should be open for extension but closed for modification. In other words, you should be able to add new functionality to a class without changing its existing code. In Java, this can be achieved using interfaces and abstract classes.
  ```
  class PaymentService {

    void pay(PaymentType paymentType) {
      //validations...

      //Every new feature requires modifying old code.
      if(paymentType.equals("CARD"))
    
      //Later
      if(paymentType.equals("UPI"))
    
      //Later
      if(paymentType.equals("PAYPAL"))
    }

  }

  //Solution: Allow extension without modification.
  interface PaymentMethod {
    void pay();
  }

  class CardPayment implements PaymentMethod {}
  class UpiPayment implements PaymentMethod {}

  class PaymentService {

    void pay(PaymentMethod paymentMethod) {
      //validations...

      paymentMethod.pay();
    }

  }
  ```
**Liskov Substitution Principle** (LSP): This principle states that subclasses should be substitutable for their base classes without causing errors. If a method expects an instance of a base class, it should be able to work with an instance of any subclass without knowing it.
```
//If a child class extends a parent class: This should work.
Bird bird = new Sparrow();

//Penguins cannot fly.
Bird bird = new Penguin();
bird.fly();

//Solution: A subtype should be usable wherever its parent is expected.
```
**Interface Segregation Principle** (ISP): This principle states that a class should not be forced to implement interfaces it does not use. Instead of one large interface, it is better to have many smaller, more specific interfaces.

```
//Huge interfaces.
interface Worker {
    work();
    eat();
    sleep();
}

//Robot doesn't eat and sleep.
class Robot implements Worker

//Interface forces classes to depend on things they don't need.
//Solution: Split interfaces.
interface Workable {
    work();
}

interface Eatable {
    eat();
}

class HumanWorker implements Workable, Eatable;
class RobotWorker implements Workable;
```
**Dependency Inversion Principle** (DIP): The Dependency Inversion Principle states that high-level modules should not depend on low-level modules. Both should depend on abstractions. In Java, this can be achieved by using interfaces or abstract classes, and using dependency injection to provide the concrete implementation.
```
//High-level code depends directly on low-level code.
class OrderService {
    MySQLDatabase db = new MySQLDatabase();
}

//How to use PostgreSQL: You must modify OrderService, Business logic is tied to implementation details.
//Solution:Depend on abstraction.
interface Database {
    save();
}

class MySQLDatabase implements Database;
class PostgreSQLDatabase implements Database;

class OrderService {
    Database db;
}
```
