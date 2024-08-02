import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiDemo {

    public static void main(String[] args) {

        Employee sridhar = new Employee("Sridhar", 100000);
        Employee vinoth = new Employee("Vinoth", 200000);
        Employee gokul = new Employee("Gokul", 200000);

        List<Employee> employeeList = Arrays.asList(sridhar, vinoth, gokul);
        List<Employee> collect = employeeList.stream().peek(employee -> System.out.println(employee.name()))
                .filter(employee -> employee.salary() > 100000)
                .toList();
        System.out.println(collect);

        List<String> strings = List.of("a", "b", "c");
        System.out.println(strings.stream().collect(Collectors.joining(", ", "{", "}")));
        System.out.println(strings.stream().reduce("", (p, it) -> p.toUpperCase() + it.toUpperCase()));

        System.out.println(employeeList.stream().reduce(0, (pResult, e) -> pResult + e.salary(), Integer::sum));
        System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::salary)));
        System.out.println(employeeList.stream().mapToLong(e -> e.name().chars().filter(c -> c == 'o').count()).sum());
    }

}

record Employee(
        String name,
        Integer salary
){}


