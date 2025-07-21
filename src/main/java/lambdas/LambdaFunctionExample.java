package lambdas;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        // Predicate
        System.out.println(findMatch(employees, e->e.getSalary() > 70000));
        System.out.println(findMatch(people, p -> p.getAge() > 30));

        // Function
        System.out.println("Sum of salaries = " + calcSum(employees, Employee::getSalary));
        System.out.println("Sum of ages = " + calcSum(people, Person::getAge));

        // Function (using stream)
        System.out.println("Sum of salaries = " + employees.stream().mapToInt(Employee::getSalary).sum());
        System.out.println("Sum of ages = " + people.stream().mapToInt(Person::getAge).sum());

        // Binary Operator
        BinaryOperator<Integer> combiner = (n1,n2) -> n1 + n2;
        Integer zeroElement = 0;
        System.out.println("Combined salary = " + combine(employees, zeroElement, Employee::getSalary, combiner));

        System.out.println("Total salary = " + combine(employees, zeroElement, Employee::getSalary, Integer::sum));
        System.out.println("Maximal salary = " + combine(employees, zeroElement, Employee::getSalary, Math::max));
        System.out.println("Minimal salary = " + combine(employees, 100000000, Employee::getSalary, Math::min));

        // Consumer
        employees.forEach(e->e.setSalary(e.getSalary()*11/10));
        employees.forEach(System.out::println);

        // Supplier
        Supplier[] shapes = {Circle::new, Rectangle::new, Square::new};
        Random random = new Random();
        for(int i = 0; i < 5; i++){
            int index = random.nextInt(shapes.length);
            Supplier supplier = shapes[index];
            supplier.get();
        }

    }

    private static <T> T findMatch(List<T> elements, Predicate<T> predicateFunction){
        for(T e: elements){
            if(predicateFunction.test(e)){
                return e;
            }
        }
        return null;
    }

    private static <T> int calcSum(List<T> elements, Function<T, Integer> function){
        int sum = 0;
        for(T e: elements){
            sum += function.apply(e);
        }
        return sum;
    }

    private static <T, R> R combine(List<T> elements, R zeroElement, Function<T, R> function, BinaryOperator<R> combiner){
        int sum = 0;
        for(T e: elements){
            zeroElement = combiner.apply(zeroElement, function.apply(e));
        }
        return zeroElement;
    }
}
