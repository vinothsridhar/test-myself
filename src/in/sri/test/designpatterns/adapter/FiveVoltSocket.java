package in.sri.test.designpatterns.adapter;

public class FiveVoltSocket implements Socket {

    @Override
    public int volt() {
        return 5;
    }

    
}
