## Encapsulation : Data and code get separated
```
//data is private so can't modify directly by other classes
//Protect data from invalid changes.
class Customer {
    private String name;
    private double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
}
```

## Inheritance : Code duplication
```
class Vehicle {
    void start() {}
    void stop() {}
}

//start() and stop() can be reused here
class Car extends Vehicle {
  int totalWheels() {
    return 4;
  }
}
class Bike extends Vehicle {
  int totalWheels() {
    return 2;
  }
}
```

## Polymorphism : Every new type requires changing old code
```
class Vehicle {
    void start() {
        System.out.println("Starting vehicle");
    }
}

//Java checks actual object at runtime.
//Same method call behaves differently depending on the object.
class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Starting Car");
    }
}

//Overload method as well considered Polymorphism
```

## Abstraction : Large systems become hard to understand
```
interface Payment {
    void pay();
}

class UpiPayment implements Payment {
    public void pay() {
        System.out.println("UPI Payment");
    }
}

class CardPayment implements Payment {
    public void pay() {
        System.out.println("Card Payment");
    }
}

//Hide implementation details.
//Users don't need internal details.They only need necessary operations.
Payment payment = new UpiPayment();
payment.pay();
```
