package in.sri.test.designpatterns.factory;

public class ChocolateIceCream implements IceCream {

    @Override
    public IceCreamFlavor flavor() {
        return IceCreamFlavor.CHOCOLOATE;
    }

    @Override
    public void make() {
        System.out.println("Chocolate ice cream made");
    }

}
