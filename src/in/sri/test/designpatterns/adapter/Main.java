package in.sri.test.designpatterns.adapter;

public class Main {

    public static void main(String[] args) {
        
        UkSocket ukSocket = new UkSocket();
        
        GermanToUkAdapter germanToUkAdapter = new GermanToUkAdapter(new GermanConnectorPlug() {
            @Override
            public void giveElectricity() {
                System.out.println("giving electricity");
            }
        });        
        
        ukSocket.plugIn(germanToUkAdapter);
        
        FiveToThreeVoltAdapter fiveToThreeVoltAdapter = new FiveToThreeVoltAdapter(new FiveVoltSocket());
        ThreeVoltPlug threeVoltPlug = new ThreeVoltPlug(fiveToThreeVoltAdapter);
        threeVoltPlug.plug();
    }
    
}
