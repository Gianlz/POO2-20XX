package Generics;

class ParChaveValor<K, V> {
    private K chave;
    private V valor;

    public ParChaveValor(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }
}

