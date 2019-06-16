package in.sri.test.designpatterns.decorator;

public class AndroidPhone extends SmartPhone {

    public AndroidPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println("Android os");
    }

}
