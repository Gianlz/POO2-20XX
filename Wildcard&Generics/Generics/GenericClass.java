package Generics;

public class GenericClass<T> {
    private T atributo;

    public GenericClass(T atributo) {
        this.atributo = atributo;
    }

    public T getAtributo() {
        return atributo;
    }

    public void setAtributo(T atributo) {
        this.atributo = atributo;
    }

}