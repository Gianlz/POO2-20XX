package Generics;

import java.util.ArrayList;
import java.util.List;
class Pedido {
    private List<ProdutoX> listaProdutos;

    public Pedido() {
        listaProdutos = new ArrayList<>();
    }

    // Método para adicionar um produto à lista de produtos
    public void adicionarProduto(ProdutoX produto) {
        listaProdutos.add(produto);
    }

    // Método para mostrar a lista de produtos
    public void mostrarProdutos() {
        System.out.println("Lista de Produtos no Pedido:");
        for (ProdutoX produto : listaProdutos) {
            System.out.println("Nome: " + produto.getNome() + " | Preço: " + produto.getPreco());
        }
    }
}