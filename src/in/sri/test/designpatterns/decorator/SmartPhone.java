package in.sri.test.designpatterns.decorator;

/**
 * This is decorator class
 * 
 */
public class SmartPhone implements Phone {
    
    private Phone phone;
    
    public SmartPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void printModel() {
        this.phone.printModel();
    }

}
