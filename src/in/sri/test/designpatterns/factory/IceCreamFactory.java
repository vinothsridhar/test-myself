package in.sri.test.designpatterns.factory;

public class IceCreamFactory {

    public static IceCream getIceCream(IceCreamFlavor iceCreamFlavor) {

        IceCream iceCream = null;

        switch (iceCreamFlavor) {

            case VENILA:
                iceCream = new VenilaIceCream();
                break;
    
            case CHOCOLOATE:
                iceCream = new ChocolateIceCream();
                break;
    
            case BADAM:
                iceCream = new BadamIceCream();
                break;
    
            default:
                break;
        }
        
        return iceCream;

    }

}
