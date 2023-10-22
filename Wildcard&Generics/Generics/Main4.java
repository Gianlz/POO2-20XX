package Generics;

public class Main4 {
    public static void main(String[] args) {
        MinhaEstrutura<String, Integer> minhaEstrutura = new MinhaEstrutura<>();

        // Adiciona pares chave-valor
        System.out.println("Adicionando pares chave-valor:");
        System.out.println("Adicionado: " + minhaEstrutura.add("Chave1", 42)); // Deve retornar true
        System.out.println("Adicionado: " + minhaEstrutura.add("Chave2", 55)); // Deve retornar true
        System.out.println("Adicionado: " + minhaEstrutura.add("Chave1", 99)); // Deve retornar false (chave já existe)

        // Busca um valor por chave
        System.out.println("\nBuscando valores por chave:");
        ParChaveValor<String, Integer> resultado1 = minhaEstrutura.buscar("Chave1");
        if (resultado1 != null) {
            System.out.println("Chave1: " + resultado1.getValor()); // Deve imprimir o valor 42
        } else {
            System.out.println("Chave1 não encontrada.");
        }

        ParChaveValor<String, Integer> resultado2 = minhaEstrutura.buscar("Chave2");
        if (resultado2 != null) {
            System.out.println("Chave2: " + resultado2.getValor()); // Deve imprimir o valor 55
        } else {
            System.out.println("Chave2 não encontrada.");
        }

        ParChaveValor<String, Integer> resultado3 = minhaEstrutura.buscar("Chave3");
        if (resultado3 != null) {
            System.out.println("Chave3: " + resultado3.getValor());
        } else {
            System.out.println("Chave3 não encontrada."); // Deve imprimir "Chave3 não encontrada."
        }
    }
}
