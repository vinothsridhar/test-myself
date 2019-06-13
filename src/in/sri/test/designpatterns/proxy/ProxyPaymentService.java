package in.sri.test.designpatterns.proxy;

public class ProxyPaymentService implements Service {
    
    private PaymentService paymentService;
    
    private String client;
    
    public ProxyPaymentService(String client) {
        this.paymentService = new PaymentService();
        this.client = client;
    }
    
    private boolean isAuthorized(String client) {
        if (client.equals("mobile")) {
            return true;
        }
        
        return false;
    }

    @Override
    public String status() {
        if (isAuthorized(client)) {
            return paymentService.status();
        } else {
            return "Access Denied";
        }
    }

}
