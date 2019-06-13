package in.sri.test.designpatterns.factory;

public class VenilaIceCream implements IceCream {

    @Override
    public IceCreamFlavor flavor() {
        return IceCreamFlavor.VENILA;
    }

    @Override
    public void make() {
        System.out.println("Venila ice cream made");
    }

}
