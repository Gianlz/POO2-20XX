package Generics;

import java.util.Date;

public class Produto<T> {
    private T id;
    private double valor;
    private Date dataFabricacao;
    private Date dataVencimento;

    public Produto(T id, double valor, Date dataFabricacao, Date dataVencimento) {
        this.id = id;
        this.valor = valor;
        this.dataFabricacao = dataFabricacao;
        this.dataVencimento = dataVencimento;
    }

    public T getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }
}