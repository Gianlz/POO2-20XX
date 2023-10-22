package Generics;

import java.util.Date;
public class ProdutoMain {
    public static void main(String[] args) {
        // Exemplo de uso com id do tipo Integer
        Produto<Integer> produto1 = new Produto<>(1001, 50.0, new Date(), new Date());
        System.out.println("Produto com ID (Integer): " + produto1.getId());
        System.out.println("Valor: " + produto1.getValor());
        System.out.println("Data de Fabricação: " + produto1.getDataFabricacao());
        System.out.println("Data de Vencimento: " + produto1.getDataVencimento());

        // Exemplo de uso com id do tipo String
        Produto<String> produto2 = new Produto<>("ABCD123", 75.0, new Date(), new Date());
        System.out.println("\nProduto com ID (String): " + produto2.getId());
        System.out.println("Valor: " + produto2.getValor());
        System.out.println("Data de Fabricação: " + produto2.getDataFabricacao());
        System.out.println("Data de Vencimento: " + produto2.getDataVencimento());
    }
}
