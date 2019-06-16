package in.sri.test.designpatterns.decorator;

public class SamsungPhone extends SmartPhone {

    public SamsungPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println("Samsung Phone");
    }

}
