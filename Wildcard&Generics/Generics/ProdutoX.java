package Generics;



// Classe ProdutoX
class ProdutoX {
    private String nome;
    private double preco;

    public ProdutoX(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}