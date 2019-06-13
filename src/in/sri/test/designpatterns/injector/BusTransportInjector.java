package in.sri.test.designpatterns.injector;

public class BusTransportInjector implements TransportInjector {

    @Override
    public TravelApplication getApp() {
        return new TravelApplication(new BusTransportService());
    }

}
