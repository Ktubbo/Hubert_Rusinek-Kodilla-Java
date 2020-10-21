package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){
        IntStream.range(0,20).forEach((x)-> System.out.println(numbers[x]));
        return IntStream.range(0,20).map(x->numbers[x]).average().getAsDouble();
    }
}
