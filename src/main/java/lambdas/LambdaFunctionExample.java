package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaFunctionExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", "Black", 25, 50000));
        employees.add(new Employee("John", "Green", 30, 75000));
        employees.add(new Employee("Sam", "Brown", 27, 80000));
        employees.add(new Employee("Tony", "Grey", 23, 90000));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alex", "Smith", 25));
        people.add(new Person("John", "Green", 30));
        people.add(new Person("Jam", "Brown", 32));
        people.add(new Person("Nicola", "Tesla", 34));

        System.out.println(findMatch(employees, e->e.getSalary() > 80000));
        System.out.println(findMatch(people, p -> p.getAge() > 32));
    }

    private static <T> T findMatch(List<T> elements, Predicate<T> predicateFunction){
        for(T e: elements){
            if(predicateFunction.test(e)){
                return e;
            }
        }
        return null;
    }
}
