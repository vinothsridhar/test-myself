package in.sri.test.designpatterns.decorator;

public class Main {

    public static void main(String[] args) {
        
        Phone basicPhone = new BasicPhone();
        
        Phone cameraPhone = new CameraPhone(basicPhone);
        
        Phone samsungPhone = new AndroidPhone(new GpsPhone(cameraPhone));
        samsungPhone.printModel();
        
        Phone applePhone = new IPhone(cameraPhone);
        applePhone.printModel();
    }
    
}
