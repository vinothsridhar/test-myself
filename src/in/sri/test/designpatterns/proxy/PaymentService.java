package in.sri.test.designpatterns.proxy;

public class PaymentService implements Service {

    @Override
    public String status() {
        return "works";
    }

}
