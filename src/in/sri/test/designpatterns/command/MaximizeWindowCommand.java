package in.sri.test.designpatterns.command;

public class MaximizeWindowCommand implements Command {
    
    private WindowService windowService;
    
    public MaximizeWindowCommand(WindowService windowService) {
        this.windowService = windowService;
    }

    @Override
    public void execute() {
        windowService.maximizeWindow();
    }

}
