package com.codescv.example.variance;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


/**
 * Created by czzha on 12/18/16.
 */
public class Variance {
    private static List<Double> fList = Arrays.asList(1.0,2.0,3.0);

    public static void main(String[] args) {
        System.out.println(intSum(fList));

        forEach(new Consumer<Number>() {
            @Override
            public void accept(Number number) {
                System.out.println("number: " + number);
            }
        });
    }

    public static Number intSum(List<? extends Number> l) {
        int sum = 0;
        for (Number n : l) {
            sum += n.intValue();
        }
        return sum;
    }

    public static void forEach(Consumer<? super Double> consumer) {
        for (double x : fList)
            consumer.accept(x);
    }
}
