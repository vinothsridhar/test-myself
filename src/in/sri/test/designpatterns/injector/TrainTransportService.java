package in.sri.test.designpatterns.injector;

public class TrainTransportService implements TransportService {

    @Override
    public void travel(String from, String to) {
        System.out.println(String.format("Train transporting from %s to %s", from, to));
    }

}
