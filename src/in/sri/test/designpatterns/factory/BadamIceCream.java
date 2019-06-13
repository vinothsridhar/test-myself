package in.sri.test.designpatterns.factory;

public class BadamIceCream implements IceCream {

    @Override
    public IceCreamFlavor flavor() {
        return IceCreamFlavor.BADAM;
    }

    @Override
    public void make() {
        System.out.println("Badam ice cream made");
    }

}
