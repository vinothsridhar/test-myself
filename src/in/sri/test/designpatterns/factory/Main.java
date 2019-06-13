package in.sri.test.designpatterns.factory;

public class Main {

    public static void main(String[] args) {
        
        IceCreamFactory.getIceCream(IceCreamFlavor.VENILA).make();
        
        IceCreamFactory.getIceCream(IceCreamFlavor.CHOCOLOATE).make();
        
        IceCreamFactory.getIceCream(IceCreamFlavor.BADAM).make();
        
    }
    
}
