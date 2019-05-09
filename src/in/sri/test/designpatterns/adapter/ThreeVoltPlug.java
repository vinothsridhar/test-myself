package in.sri.test.designpatterns.adapter;

public class ThreeVoltPlug {
    
    Socket socket;
    
    public ThreeVoltPlug(Socket socket) {
        this.socket = socket;
    }

    public void plug() {
        System.out.println(socket.volt());
    }
    
}
