package lambdas;

import shapes.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number>{
    public double process(T element1);
}

@FunctionalInterface
interface Operation {
    void process();

    static void measure(Operation function){
        long start = System.currentTimeMillis();
        function.process();
        long end = System.currentTimeMillis();
        System.out.println("Time spent: " + (end - start) + " milliseconds");
    }

    default Operation combineOperation(Operation that){
        return () -> {
            process();
            that.process();
        };
    }
}

public class LambdaExample {
    public static void main(String[] args) {
//        List<Integer> intList = new ArrayList<>();
//        for(int i = 1; i < 5; i++){
//            intList.add(i);
//        }
//
//        List<Double> doubleList = new ArrayList<>();
//        for(double i = 1.1; i < 6; i+=1){
//            doubleList.add(i);
//        }
//
//        processElements(intList, LambdaExample::multiply);
//        processElements(doubleList, x -> Math.sin(x.doubleValue()));

        Operation operation1 = () -> Arrays.sort(createRandomArray(10000000, 1000000));
        Operation operation2 = () -> Arrays.sort(createRandomArray(10000000, 1000000));
        Operation.measure(operation1.combineOperation(operation2));

//        String s = "Hello ";
//        Double d = 0.001;
//
//        TransformUtils<Double> doubleUtils = new TransformUtils<>();
//        System.out.println(doubleUtils.transform(d, Math::sin));
//
//        TransformUtils<String> stringUtils = new TransformUtils<>();
//        System.out.println(stringUtils.transform(s, TransformUtils::exclaim));
//
//        String suffix = "Alex!";
//        System.out.println(stringUtils.transform(suffix, s::concat));
//
//        System.out.println(stringUtils.transform(s, String::toUpperCase));
//
//        System.out.println(stringUtils.transform(s, String::new));

        Circle c = new Circle();
        System.out.println(c.calcSomething());




    }

    private static <T extends Number> void processElements(List<T> intList, ElementProcessor function){
        List<Double> doubleList = new ArrayList<>();
        for(Number i: intList){
            doubleList.add(function.process(i));
        }

        System.out.println(doubleList);
    }

    private static double multiply(Number x){
        return x.doubleValue() * 10.0;
    }

    private static int[] createRandomArray(int length, int max){
        int[] array = new int[length];
        Random r = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt(max);
        }
        return array;
    }
}
