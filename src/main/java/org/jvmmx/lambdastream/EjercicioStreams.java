package org.jvmmx.lambdastream;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjercicioStreams {
    
    private static final String PALABRA = "[- .:;,¡!]";
    
    /**
     * Cuenta las líneas del archivo usando el reader provisto
     */
    private void ejercicio1() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí
            System.out.println("El poema tiene " + reader.lines().count() + " lineas.");


            
        }
    }

    /**
     * Crea una lista de palabras sin duplicados del archivo provisto en reader
     * Tip: Ya se cuenta con la expresión PALABRA
     */
    private void ejercicio2() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí
            //List<String> lista = new ArrayList<String>();

//            reader.lines()
//                    .flatMap(s -> Stream.of(s.split(" ")))
//                    .forEach(System.out::println);



        }
    }
    
    /**
     * Crea una lista de palabras en minusculas y sin duplicados 
     * del archivo provisto en reader y ordenadas alfabéticamente
     */
    private void ejercicio3() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí

            //System.out.println(
            List<String> listaFiltrada =
            reader.lines()
                    .flatMap(s -> Stream.of(s.split(PALABRA)))
                    .map(String::trim) //quito espacios delante y detras
                    //.filter(s -> s.length() !=  0) //excluyo los que sean tamaño 0 (espacios)
                    .filter(s -> !s.isEmpty())//idem que anterior pero mas moderno
                    .map(String::toLowerCase)//a minusculas
                    .distinct()//descarto iguales
                    //.sorted(Comparator.naturalOrder()) //ordenar
                    .sorted()//ordenar
                    //.forEach(System.out::println);//imprimo
                    .collect(Collectors.toList());//meto en coleccion
                    //.count() //para imprimir cantidad

            //);//pruebas de system.out...
            System.out.println(listaFiltrada);
        }
    }
    
    /**
     * Modifica el ejercicio3 para que las palabras esten ordenadas por longitud
     */
    private void ejercicio4() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí
            //List<String> listaFiltrada =
                reader.lines()
                        .flatMap(s -> Stream.of(s.split(PALABRA)))
                        .map(String::trim)
                        .filter( s -> !s.isEmpty())
                        .map( s -> s.toLowerCase())
                        .distinct()
                        .sorted((s1, s2) -> s1.length() - (s2.length()))
                        .map( s -> s + " ")
                        .peek(System.out::print).count();



        }
    }
    
    /**
     * Has un histograma de cada palabra que aparece, todas en minúsculas
     */
    private void ejercicio5() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(
                Paths.get("poema.txt"), StandardCharsets.UTF_8)){
            
            // código aquí
            //Map<String, Integer> histograma = new HashMap<String, Integer>();
            Map<String, Integer> histograma =
            reader.lines()
                    .flatMap( s -> Stream.of(s.split(PALABRA)))
                    .map(String::trim)
                    .filter( s -> !s.isEmpty())
                    .map( s -> s.toLowerCase())
                    .collect(Collectors.toMap(Function.identity(), s -> 1, ( a,b) -> a+b));
                    //.forEach(System.out::println);
            System.out.println("Histograma: " + histograma);
        }
    }
    
    /**
     * Complementa el código para la clase RandomWords 
     * con una lista de 1000 palabras agrupalas por longitud
     */
    private void ejercicio6() throws IOException {
        RandomWords rand = new RandomWords();
        List<String> list = rand.createList(1000);
        
        //código aquí
        
    }
    
    
    public static void main(String[] args) throws IOException {
        EjercicioStreams es = new EjercicioStreams();
        System.out.println("Lambdas y Stream API EjercicioStreams");
        System.out.println("Ejercicio 1");
        es.ejercicio1();
        System.out.println("Ejercicio 2");
        es.ejercicio2();
        System.out.println("Ejercicio 3");
        es.ejercicio3();
        System.out.println("Ejercicio 4");
        es.ejercicio4();
        System.out.println("Ejercicio 5");
        es.ejercicio5();
//        System.out.println("Ejercicio 6");
//        es.ejercicio6();
    }
    
}
