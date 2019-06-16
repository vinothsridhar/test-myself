package in.sri.test.designpatterns.decorator;

public class BasicPhone implements Phone {

    @Override
    public void printModel() {
        System.out.println("Basic Phone");        
    }

}
