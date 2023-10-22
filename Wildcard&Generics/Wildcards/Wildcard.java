package Wildcards;


import java.util.List;

public class Wildcard {
    // Wildcard com limite superior
    public static double somar(List<? extends Number> numeros) {
        double total = 0;
        for (Number numero : numeros) {
            total += numero.doubleValue();
        }
        return total;
    }


    public static void imprimirDados(List<? extends CharSequence> dados) {
        for (CharSequence item : dados) {
            System.out.println(item);
        }
    }

    // Wildcard com limite inferior
    public static void adicionarNumeros(List<? super Integer> numeros) {
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
    }

    public static void imprimirDadosLower(List<? super String> dados) {
        for (Object item : dados) {
            System.out.println(item);
        }
    }

    // Wildcard sem limite
    public static void imprimirDadosSemLimite(List<?> dados) {
        for (Object item : dados) {
            System.out.println(item);
        }
    }

    public static double somarSemLimite(List<?> numeros) {
        double total = 0;
        for (Object numero : numeros) {
            if (numero instanceof Number) {
                total += ((Number) numero).doubleValue();
            }
        }
        return total;
    }


}
