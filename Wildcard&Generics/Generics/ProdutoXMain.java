package Generics;

public class ProdutoXMain {
    public static void main(String[] args) {
        // Criação de produtos ProdutoX
        ProdutoX produto1 = new ProdutoX("Produto A", 25.0);
        ProdutoX produto2 = new ProdutoX("Produto B", 12.5);
        ProdutoX produto3 = new ProdutoX("Produto C", 30.0);

        // Criação de um pedido
        Pedido pedido = new Pedido();

        // Adiciona produtos ao pedido
        pedido.adicionarProduto(produto1);
        pedido.adicionarProduto(produto2);
        pedido.adicionarProduto(produto3);

        // Mostra a lista de produtos no pedido
        pedido.mostrarProdutos();
    }
}
