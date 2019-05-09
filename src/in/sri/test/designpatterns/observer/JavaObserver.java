package in.sri.test.designpatterns.observer;

public class JavaObserver implements Observer {
    
    private Topic topic;

    @Override
    public void update() {
        String update = (String) topic.getUpdate(this);
        System.out.println(update);
    }

    @Override
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
