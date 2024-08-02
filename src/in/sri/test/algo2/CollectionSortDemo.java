import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionSortDemo {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student(
                        "Sridhar",
                        3
                ),
                new Student(
                        "Vinoth",
                        1
                )
        );

        List<Student> mutableList = new ArrayList<>(students);

        mutableList.sort(new MyComparator());
        System.out.println(mutableList);

        Set<String> treeset = new TreeSet<>();

    }

}

record Student(
        String name,
        Integer id
){}

class MyComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.id() - o2.id();
    }
}