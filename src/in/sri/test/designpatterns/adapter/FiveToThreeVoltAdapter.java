package in.sri.test.designpatterns.adapter;

public class FiveToThreeVoltAdapter implements Socket {
    
    private FiveVoltSocket fiveVoltSocket;
    
    public FiveToThreeVoltAdapter(FiveVoltSocket fiveVoltSocket) {
        this.fiveVoltSocket = fiveVoltSocket;
    }

    @Override
    public int volt() {
        return fiveVoltSocket.volt() - 2;
    }

}
