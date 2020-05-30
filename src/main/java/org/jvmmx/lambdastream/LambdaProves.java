package org.jvmmx.lambdastream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaProves {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Xavi");
        list.add("Marteta");
        list.add("Pol");
        list.add("Lluis");
        list.add("hola que tal");

        //pasar a mayusculas + ordenar al reves + imprimir:
        list.stream().map(s -> s.toUpperCase())
                //opcion1
                //.sorted((o1, o2) -> o2.compareTo(o1))
                //opcion2
                .sorted(Comparator.reverseOrder())
                .forEach(s -> System.out.println(s));

        //poner en objeto StringBuilder nuevo la primera letra de cada elemento
        StringBuilder result = new StringBuilder();
        list.forEach(s -> result.append(s.charAt(0)));
        System.out.println("Resultat StringBuilder: " + result);

        //contar letras de cada palabra y ponerlas en una colección hashmap histograma
        Map<Integer, String> histogram = new HashMap<>();
        list.stream().map(s -> histogram.put(s.length(), s))
        //.forEach(System.out::println);
        .collect(Collectors.toList());
        histogram.forEach((i,k)-> System.out.println("Letras: " + i + " Palabra: " + k));


    }
}
