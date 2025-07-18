package lambdas;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface ElementProcessor<T extends Number>{
    public double process(T element1);
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
}
