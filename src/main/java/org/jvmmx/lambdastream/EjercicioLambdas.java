package org.jvmmx.lambdastream;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class EjercicioLambdas {


    /**
     * Imprimir una cadena formada de la primer letra de cada palabra en la lista
     */
    private void ejercicio1() {
        List<String> list = Arrays.asList(
                "Abraham", "Carlos", "Daniel","Esteban","Francisco","Gustavo","Hugo","Ignacio"
        );
        
        //Código aquí
        StringBuilder result = new StringBuilder();//para guardar resultado
        list.forEach(s -> result.append(s.charAt(0)));
        System.out.println("Resultado: " + result);
        //con lambdas
        //list.forEach(x -> System.out.println(x));
        //con referencias a metodos
        //list.forEach(System.out::println);
        
    }
    
    /**
     * Imprimir sólo las palabras de longitud par
     */
    private void ejercicio2() {
        List<String> list = new ArrayList(Arrays.asList(
                "Abraham", "Carlos", "Daniel","Esteban","Francisco","Gustavo","Hugo","Ignacio"
        ));
        
        //Código aquí
        //opcion solo imprimiendo

        //opcion eliminando de lista
        list.removeIf(s -> s.length() % 2 != 0);
        list.forEach(System.out::println);

    }
    
    /**
     * Imprimir las palabras convertidas a mayúsculas 
     */
    private void ejercicio3() {
        List<String> list = Arrays.asList(
                "Abraham", "Carlos", "Daniel","Esteban","Francisco","Gustavo","Hugo","Ignacio"
        );
        
        //Código aquí
        list.replaceAll(s -> s.toUpperCase());
        System.out.println("Print: " + list);
        
    }
    
    /**
     * Crear un hilo que imprima los números de la lista
     */
    private void ejercicio4() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        //Código aquí
        (new Thread(()-> list.forEach(System.out::println))).start();
        (new Thread(()-> System.out.println("hola"))).start();
    }
    
    public static void main(String[] args) {
        EjercicioLambdas el = new EjercicioLambdas();
        System.out.println("Lambdas y Stream API EjercicioLambdas");
        System.out.println("Ejercicio 1");
        el.ejercicio1();
        System.out.println("Ejercicio 2");
        el.ejercicio2();
        System.out.println("Ejercicio 3");
        el.ejercicio3();
        System.out.println("Ejercicio 4");
        el.ejercicio4();
        
    }

    

}
