package in.sri.test.designpatterns.command;

public class Main {

    public static void main(String[] args) {
        
        WindowService windowService = new WindowService();
        
        new MaximizeWindowCommand(windowService).execute();
        
        new MinimizeWindowCommand(windowService).execute();
        
    }
    
}
