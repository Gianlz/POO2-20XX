package Generics;

import java.util.ArrayList;

class MinhaEstrutura<K, V> {
    private ArrayList<ParChaveValor<K, V>> lista;

    public MinhaEstrutura() {
        lista = new ArrayList<>();
    }

    // Método para adicionar um par chave-valor
    public boolean add(K chave, V valor) {
        for (ParChaveValor<K, V> par : lista) {
            if (par.getChave().equals(chave)) {
                return false; // A chave já existe na lista
            }
        }
        lista.add(new ParChaveValor<>(chave, valor));
        return true;
    }

    // Método para buscar um valor com base na chave
    public ParChaveValor<K, V> buscar(K chave) {
        for (ParChaveValor<K, V> par : lista) {
            if (par.getChave().equals(chave)) {
                return par;
            }
        }
        return null; // Chave não encontrada
    }
}
