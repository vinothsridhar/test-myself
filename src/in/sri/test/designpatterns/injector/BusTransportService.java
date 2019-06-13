package in.sri.test.designpatterns.injector;

public class BusTransportService implements TransportService {

    @Override
    public void travel(String from, String to) {
        System.out.println(String.format("Bus transporting from %s to %s", from, to));
    }

}
