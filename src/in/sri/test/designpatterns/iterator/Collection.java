package in.sri.test.designpatterns.iterator;

public interface Collection<T> {

    void add(T t);
    
    Iterator<T> iterator();
    
}
