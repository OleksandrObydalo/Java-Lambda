package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number>{
    public double process(T element1);
}

@FunctionalInterface
interface ExecutiveFunction{
    void process();
}

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        for(int i = 1; i < 5; i++){
            intList.add(i);
        }

        List<Double> doubleList = new ArrayList<>();
        for(double i = 1.1; i < 6; i+=1){
            doubleList.add(i);
        }

        processElements(intList,  x -> Math.sin(x.doubleValue()));
        processElements(doubleList, x -> Math.sin(x.doubleValue()));

        TimeUtil.measure(() -> Arrays.sort(createRandomArray(10000000, 1000000)));


    }

    private static <T extends Number> void processElements(List<T> intList, ElementProcessor function){
        List<Double> doubleList = new ArrayList<>();
        for(Number i: intList){
            doubleList.add(function.process(i));
        }

        System.out.println(doubleList);
    }

    private static double multiply(int x, int y){
        return x * y / 10.0;
    }

    private static int[] createRandomArray(int length, int max){
        int[] array = new int[length];
        Random r = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = r.nextInt(max);
        }
        return array;
    }

    public static class TimeUtil{
        private static void measure(Runnable function){
            long start = System.currentTimeMillis();
            function.run();
            long end = System.currentTimeMillis();
            System.out.println("Time spent: " + (end - start) + " milliseconds");
        }
    }
}
