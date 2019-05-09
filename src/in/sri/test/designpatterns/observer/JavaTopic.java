package in.sri.test.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class JavaTopic implements Topic {
    
    private List<Observer> list = new ArrayList<Observer>();
    
    private boolean changed;
    
    private String message;

    @Override
    public void register(Observer observer) {
        list.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        List<Observer> localList = new ArrayList<Observer>(this.list);
        this.changed = false;
        for (Observer observer : localList) {
            observer.update();
        }
    }

    @Override
    public String getUpdate(Observer observer) {
        return message;
    }
    
    public void postMessage(String message) {
        this.message = message;
        this.changed = true;
        notifyObservers();
    }

}
