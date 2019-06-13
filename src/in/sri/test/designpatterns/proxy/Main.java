package in.sri.test.designpatterns.proxy;

public class Main {

    public static void main(String[] args) {
        ProxyPaymentService paymentService = new ProxyPaymentService("mobile");
        System.out.println(paymentService.status());
        
        ProxyPaymentService desktopPaymentService = new ProxyPaymentService("desktop");
        System.out.println(desktopPaymentService.status());
    }
    
}
