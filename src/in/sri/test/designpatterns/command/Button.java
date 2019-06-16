package in.sri.test.designpatterns.command;

public class Button {
    
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void onPress() {
        command.execute();
    }
    
}
