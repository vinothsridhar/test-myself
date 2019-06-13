package in.sri.test.designpatterns.injector;

public class TravelApplication {

    private TransportService transportService;
    
    public TravelApplication(TransportService transportService) {
        this.transportService = transportService;
    }
    
    public void travel(String from, String to) {
        transportService.travel(from, to);
    }
    
}
