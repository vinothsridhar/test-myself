import java.util.LinkedHashSet;
import java.util.Set;

public class CollectionDemo {

    public static void main(String[] args) throws InterruptedException {

        Set<String> set = new LinkedHashSet<>();
        set.add("A");
        set.add("C");
        set.add("B");
        set.add("EC");
        set.add("D");
        set.add("Z");
        set.add("P");
        System.out.println(set);
    }

}
