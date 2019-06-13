package in.sri.test.designpatterns.command;

public class MinimizeWindowCommand implements Command {
    
    private WindowService windowService;
    
    public MinimizeWindowCommand(WindowService windowService) {
        this.windowService = windowService;
    }

    @Override
    public void execute() {
        windowService.minimizeWindow();
    }

}
