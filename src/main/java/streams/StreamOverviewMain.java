package streams;
import lambdas.Employee;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOverviewMain {
    static List<Employee>  employeeList = new ArrayList<>();
    static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) {
        employeeList.add(new Employee(1, "Alex", "Black", 30, 50000));
        employeeList.add(new Employee(2, "John", "Green", 35, 75000));
        employeeList.add(new Employee(6, "Sam", "Brown", 27, 80000));
        employeeList.add(new Employee(9, "Tony", "Grey", 36, 90000));
        employeeList.add(new Employee(10, "Mike", "Yellow", 23,  60000));
        employeeList.add(new Employee(11, "Victoria", "Pink", 21, 75000));
        employeeList.add(new Employee(16, "Sean", "Magenta", 28, 80000));
        employeeList.add(new Employee(19, "Kate", "Black", 34, 88000));
        employeeList.add(new Employee(9, "Tony", "Grey", 40, 90000));
        employeeList.add(new Employee(10, "Mike", "Yellow", 42, 60000));
        employeeList.add(new Employee(11, "Victoria", "Pink", 32, 75000));

        testStreamFromList();
    }

    private static void testStreamFromList() {
//        employeeList.stream()
//                .filter(e -> e.getSalary() > 60000)
//                .filter(e -> e.getId() > 10)
//                .forEach(System.out::println);

        Integer[] ids = new Integer[20];
        for(int i = 0; i < ids.length; i++){
            ids[i] = i + 1;
        }

//        Stream.of(ids)
//                .map(StreamOverviewMain::findById)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        Optional<Employee> first = Stream.of(ids)
                .map(StreamOverviewMain::findById)
                .filter(Objects::nonNull)
                .findFirst();

        System.out.println("first = " + first);
        System.out.println("first.get() =" +first.get());
    }

    private static Employee findById(int id){
        if(employeeMap == null){
            employeeMap = employeeList.stream().distinct().collect(Collectors.toMap(Employee::getId, e->e));
        }
        return employeeMap.get(id);
    }
}
