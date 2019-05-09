package in.sri.test.designpatterns.adapter;

public class GermanToUkAdapter implements UkConnectorPlug {
    
    private GermanConnectorPlug germanConnectorPlug;
    
    public GermanToUkAdapter(GermanConnectorPlug germanConnectorPlug) {
        this.germanConnectorPlug = germanConnectorPlug;
    }

    @Override
    public void privideElectricity() {
        germanConnectorPlug.giveElectricity();
    }

}
