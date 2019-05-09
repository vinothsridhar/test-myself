package in.sri.test.designpatterns.observer;

public interface Topic {

    void register(Observer observer);
    
    void unregister(Observer observer);
    
    void notifyObservers();
    
    Object getUpdate(Observer observer);
    
}
