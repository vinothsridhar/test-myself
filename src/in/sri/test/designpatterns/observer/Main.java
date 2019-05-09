package in.sri.test.designpatterns.observer;

public class Main {

    public static void main(String[] args) {
        
        JavaTopic javaTopic = new JavaTopic();
        
        JavaObserver javaObserver1 = new JavaObserver();
        javaObserver1.setTopic(javaTopic);
        
        JavaObserver javaObserver2 = new JavaObserver();
        javaObserver2.setTopic(javaTopic);
        
        javaTopic.register(javaObserver1);
        javaTopic.register(javaObserver2);
        
        javaTopic.postMessage("Java version 9 available");
        
        javaTopic.unregister(javaObserver1);
        
        javaTopic.postMessage("Java version 10 available");
    }
    
}
