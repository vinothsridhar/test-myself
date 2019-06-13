package in.sri.test.designpatterns.injector;

public class FlightTransportInjector implements TransportInjector {

    @Override
    public TravelApplication getApp() {
        return new TravelApplication(new FlightTransportService());
    }

}
