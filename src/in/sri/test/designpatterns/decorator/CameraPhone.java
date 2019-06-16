package in.sri.test.designpatterns.decorator;

public class CameraPhone extends SmartPhone {

    public CameraPhone(Phone phone) {
        super(phone);
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println("camera features");
    }
    
}
