package org.jvmmx.lambdastream;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EjercicioUsuariosFiltrados {

    private static List<String> usuarios = new LinkedList<String>();

    public static void aplicarFiltroV1(List<String> usuarios,
                                     Predicate<String> criterio,
                                     Consumer<String> accion){
        for (String usuario: usuarios) {
            if (criterio.test(usuario)){
                accion.accept(usuario);
            }
        }
    }

    public static void imprimir (String usuarios){
        System.out.println(usuarios);
    }

    public static List<String> aplicarFiltroV2(
                                    List<String> usuarios,
                                    Predicate<String> criterio){
        return usuarios
                .stream()
                .filter(criterio)
                .collect(Collectors.toList());
    }

//    public static List<String> aplicarFiltroV3(
//                                    List<String> usuarios,
//                                    Predicate<String> criterio,
//                                    Function<String, String> mapper){
//        return usuarios
//                .stream()
//                .filter(criterio)
//                .map(mapper)
//                .collect(Collectors.toList());
//
//    }

    public static void main(String[] args){
        usuarios.add("xavi");
        usuarios.add("marta");
        usuarios.add("pol");
        usuarios.add("lluis");
        //V1
        aplicarFiltroV1(
                usuarios,
                s -> s.length() == 4,
                //s -> System.out.println(s)); //opción sin referencia a metodo
                EjercicioUsuariosFiltrados::imprimir);

        //V2
        List<String> filtrada = aplicarFiltroV2(
                                        usuarios,
                                        s -> s.length() == 4);
        System.out.println(filtrada);

    }
}
