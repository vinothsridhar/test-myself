package in.sri.test.designpatterns.command;

public class Main {

    public static void main(String[] args) {
        
        WindowService windowService = new WindowService();
        
        Button maximizeButton = new Button();
        maximizeButton.setCommand(new MaximizeWindowCommand(windowService));
        
        Button minimizeButton = new Button();
        minimizeButton.setCommand(new MinimizeWindowCommand(windowService));

        maximizeButton.onPress();
        minimizeButton.onPress();
        
    }
    
}
