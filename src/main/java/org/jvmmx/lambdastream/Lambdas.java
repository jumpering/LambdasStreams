package org.jvmmx.lambdastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambdas {


    public static boolean esPar(Integer n){
        return (n % 2  != 0);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        //poner en otra lista solo los pares:
        List<Integer> numbersPar = numbers.stream()
            .filter(i -> i % 2 == 0)
            .collect(Collectors.toList());
        numbersPar.stream()
                .forEach(System.out::print);

        //ahora poner en la misma lista (ojo que Arrays no permite eliminar?¿)

        System.out.println("");

        List<Integer> numbersV2 = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9));
        numbersV2.removeIf(Lambdas::esPar);
        numbersV2.forEach(System.out::print);

    }
}
