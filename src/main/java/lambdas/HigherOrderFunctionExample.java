package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HigherOrderFunctionExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", "Black", 25, 50000));
        employees.add(new Employee("John", "Green", 30, 75000));
        employees.add(new Employee("Sam", "Brown", 27, 80000));
        employees.add(new Employee("Tony", "Grey", 23, 90000));

        testPredicate(employees);
    }
    private static void testPredicate(List<Employee> employees){
        System.out.println("Testing predicate...");
        Predicate<Employee> isRich = x -> x.getSalary() >= 50000;
        Predicate<Employee> isYoung = x -> x.getAge() <= 25;
        System.out.println("Is Rich AND Young");
        findAll(employees, isRich.and(isYoung)).forEach(System.out::println);
        System.out.println("Is Rich OR Young");
        findAll(employees, isRich.or(isYoung)).forEach(System.out::println);
        System.out.println("Is NOT Young");
        findAll(employees, isYoung.negate()).forEach(System.out::println);

    }

    private static <T> List<T> findAll(List<T> elements, Predicate<T> predicate){

        return elements.stream().filter(predicate).toList();
    }
}
