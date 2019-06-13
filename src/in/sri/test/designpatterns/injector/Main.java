package in.sri.test.designpatterns.injector;

public class Main {

    public static void main(String[] args) {
        
        new FlightTransportInjector().getApp().travel("chennai", "hyderabad");
        
        new TrainTransportInjector().getApp().travel("hyderabad", "pune");
        
        new BusTransportInjector().getApp().travel("pune", "mumbai");
        
    }
    
}
