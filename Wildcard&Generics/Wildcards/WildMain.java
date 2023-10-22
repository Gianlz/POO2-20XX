package Wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildMain {
    public static void main(String[] args) {

        // Wildcard com limite superior
        List<String> strings = Arrays.asList("Olá", "Mundo");

        Wildcard.imprimirDados(strings);

        List<Integer> inteiros = Arrays.asList(1, 2, 3);

        double resultado = Wildcard.somar(inteiros);
        System.out.println(resultado);

        // Wildcard com limite inferior

        List<Number> numeros = new ArrayList<>();
        Wildcard.adicionarNumeros(numeros);

        List<Object> objetos = new ArrayList<>();
        objetos.add("Olá");
        objetos.add("Mundo");
        Wildcard.imprimirDadosLower(objetos);

        // Wildcard sem limite


        Wildcard.imprimirDadosSemLimite(inteiros);

        Wildcard.imprimirDadosSemLimite(strings);

        double resultadoSemLimite = Wildcard.somar(inteiros);
        System.out.println(resultadoSemLimite);


    }


}
