package org.jvmmx.lambdastream;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaProves {

    private static String lengthKeyword;

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Xavi");
        list.add("Marteta");
        list.add("Pol");
        list.add("Lluis");
        list.add("hola que tal");

        List<String> listB = new ArrayList<String>(Arrays.asList("javier,marta,pol,luis"));

        //pasar a mayusculas + ordenar al reves + imprimir:
        listB.stream().map(s -> s.toUpperCase())
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
        .collect(Collectors.toList());
        histogram.forEach((i,k)-> System.out.println("Letras: " + i + " Palabra: " + k));

        System.out.println("---------------------------------------");
        //AHORA CON FILE EXTERNO
//        try (BufferedReader reader = Files.newBufferedReader(
//                Paths.get("poema.txt"), StandardCharsets.UTF_8)){

        //imprimo todas las palabras que tiene el texto (quito comas, puntos, saltos de linea,...)
//            toAnalize().lines().flatMap(linea -> Stream.of(linea.split("[- .:;,¡!]")))
//                    .filter(palabra -> !palabra.isEmpty())
//                    .forEach(System.out::println);

            //cuantas lineas tiene el texto
            System.out.println(
                "Hay " +
                toAnalize().lines().count() +
                " lineas en el poema."
            );

            //cuantas palabras tiene el texto
            System.out.println(
                    "Hay " +
                            toAnalize().lines().flatMap(linea -> Stream.of(linea.split("[- .:;,¡!]")))
                                .filter(palabra -> !palabra.isEmpty())
                                .count() +
                            " palabras en el poema."
            );

        //cuantas palabras sin repitidas (imprimir numero) (no discriminar Mayusculas de minusculas)
            System.out.println( "Palabras sin repetir: " +
                toAnalize().lines().flatMap(linea -> Stream.of(linea.split("[- .:;,¡!]")))
                    .map(palabra -> palabra.toLowerCase())
                    .filter(palabra -> !palabra.isEmpty())
                    .distinct()
                    .count()
            );

            //numero total de caracteres
            System.out.println( "Total caracteres: " +
                    toAnalize().lines().flatMap(linea -> Stream.of(linea.split("")))
                            .count()
            );

        //numero total de caracteres sin espacios
        System.out.println( "Total caracteres sin espacios: " +
                toAnalize().lines().flatMap(linea -> Stream.of(linea.split("")))
                        .filter(character -> !character.isEmpty())
                        .count()
        );

            //numero total de caracteres sin repetir
            System.out.println( "Total caracteres sin repetir: " +
                    toAnalize().lines().flatMap(linea -> Stream.of(linea.split("")))
                            .distinct()
                            .count()
            );

        //contar veces cierta palabra en texto (por ejemplo México)
        System.out.println(
                "La palabra 'México' aparece " +
                        toAnalize().lines().flatMap(lines -> Stream.of(lines.split("[- .:;,¡!]")))
                                .map(keyword -> keyword.toLowerCase())
                                .filter(keyword -> keyword.equals("méxico"))
                                .count() +
                        " veces (no discrimina mayúsculas de minúsculas)."
        );

        //buscar la palabra más larga del texto
//        final int lengthKeyword = 0;
        System.out.println(
                "La palabra más larga del poema es: '" +
                        toAnalize().lines().flatMap(lines -> Stream.of(lines.split("[- .:;,¡!]")))
                        .filter(keyword -> !keyword.isEmpty())
                        .sorted(Comparator.comparing(keyword -> keyword.length()))
                        .reduce((a,b)-> b) //para mostrar el último
                        .map(keyword -> lengthKeyword = keyword)
                        //.map(keyword -> keyword + " \n")
                        //.findFirst()
                        .get() +
                        //.collect(Collectors.joining()) +
                        "' con " +
                        lengthKeyword.length() +
                        " carácteres de longitud."
        );

        //frase más larga
        String[] split = toAnalize().lines()
                .collect(Collectors.joining(" "))
                .split("\\.");
        
        Arrays.stream(split)
                .max(Comparator.comparingInt(String::length))
                .ifPresent(x -> System.out.println("La frase mas larga: " + x));

        //cambiar cierta palabra
//        toAnalize().lines()
//                .flatMap(line -> Stream.of(line))
//                .map(character -> character.replace("México" , "Cachoperro"))
//                .forEach(System.out::println);

        //eliminar cierta palabra
//        toAnalize().lines()
//                .flatMap(line -> Stream.of(line))
//                .filter(character -> !character.contains("México"))
//                .forEach(System.out::println);

//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    public static BufferedReader toAnalize(){
        try{
            BufferedReader reader = Files.newBufferedReader(Paths.get("poema.txt"), StandardCharsets.UTF_8);

            return reader;
        } catch (Exception e){

        }
        return null;
    }
}

