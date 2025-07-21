package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderFunctionExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", "Black", 25, 50000));
        employees.add(new Employee("John", "Green", 30, 75000));
        employees.add(new Employee("Sam", "Brown", 27, 80000));
        employees.add(new Employee("Tony", "Grey", 23, 90000));

        testPredicate(employees);
        testFunction(employees);
        testConsumer(employees, x -> x.setSalary(x.getSalary() * 11 / 10));

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

        List<T> filteedList = new ArrayList<>();
        for(T elewent: elements){
            if(predicate.test(elewent)) filteedList.add(elewent);
        }
        return filteedList;

        // Code higher can be replaced by code lower
//      return elements.stream().filter(predicate).toList();
    }

    private static void testFunction(List<Employee> employees){
        System.out.println("Testing function");
        Function<Employee, String> name = x -> x.getFirstName() + " " + x.getLastName();
        Function<String, String> sayHello = y -> "Hello " + y;
        Function<Employee, String> composedFunction = sayHello.compose(name);
        List<String> transformedList = transform(employees, composedFunction);
        transformedList.forEach(System.out::println);

        Function<String, String> exlaim = z -> z + "!!!";
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> repeat = z -> z + " " + z;
        transform(transformedList, compose(repeat, exlaim, toUpper)).forEach(System.out::println);


    }

    private static <T> Function<T,T> compose(Function<T,T>... functions){
        Function<T,T> composed = Function.identity();
        for(Function<T,T> function: functions) {
            composed = composed.compose(function);
        }

        return composed;

    }


    private static <T,R> List<R> transform(List<T> elements, Function<T, R> function){
        List<R> transformedList = new ArrayList<>();
        for(T elewent: elements){
            transformedList.add(function.apply(elewent));
        }
        return transformedList;

        // Code higher can be replaced by code lower
//        return elements.stream().map(function).toList();
    }

    private static void testConsumer(List<Employee> employees, Consumer<Employee> consumer){
        System.out.println("Testing consumer");
        processList(employees, consumer.andThen(System.out::println));

    }

    private static <T> void  processList(List<T> elements, Consumer<T> consumer) {
        for(T e: elements){
            consumer.accept(e);
        }
    }



}
