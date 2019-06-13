package in.sri.test.designpatterns.injector;

public class FlightTransportService implements TransportService {

    @Override
    public void travel(String from, String to) {
        System.out.println(String.format("Flight transporting from %s to %s", from, to));
    }

}
