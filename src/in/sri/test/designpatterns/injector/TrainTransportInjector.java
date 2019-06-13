package in.sri.test.designpatterns.injector;

public class TrainTransportInjector implements TransportInjector {

    @Override
    public TravelApplication getApp() {
        return new TravelApplication(new TrainTransportService());
    }

}
