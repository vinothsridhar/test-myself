package in.sri.test.designpatterns.decorator;

public class GpsPhone extends SmartPhone {

    public GpsPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println("gps features");
    }
    
}
