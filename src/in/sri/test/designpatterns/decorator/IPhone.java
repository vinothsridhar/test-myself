package in.sri.test.designpatterns.decorator;

public class IPhone extends SmartPhone {

    public IPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println("Iphone os");
    }

}
