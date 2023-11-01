package Junit.calcular;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Calculo {
    public double Moda(double[] numeros) {
        Map<Double, Integer> freqMap = new HashMap<>();
        double maxValor = 0, maxContador = 0;

        for (double numero : numeros) {
            int contador = freqMap.getOrDefault(numero, 0) + 1;
            freqMap.put(numero, contador);

            if (contador > maxContador) {
                maxContador = contador;
                maxValor = numero;
            }
        }
        return maxValor;
    }

    public double Media(double[] numeros) {
        double soma = 0;
        for (double numero : numeros) {
            soma += numero;
        }
        return soma / numeros.length;
    }

    public double Mediana(double[] numeros) {
        Arrays.sort(numeros);
        int meio = numeros.length / 2;
        if (numeros.length % 2 == 1) {
            return numeros[meio];
        } else {
            return (numeros[meio - 1] + numeros[meio]) / 2.0;
        }
    }

    public double Variancia(double[] numeros) {
        double media = Media(numeros);
        double soma = 0;
        for (double num : numeros) {
            soma += Math.pow(num - media, 2);
        }
        return soma / numeros.length;
    }

    public double DesvioPadrao(double[] numeros) {
        return Math.sqrt(Variancia(numeros));
    }
}
