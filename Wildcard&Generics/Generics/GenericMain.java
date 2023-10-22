package Generics;

public class GenericMain {
    public static void main(String[] args) {
        // Usando a classe genérica com uma String
        GenericClass<String> stringObj = new GenericClass<>("Isso é uma string");
        String stringValor = stringObj.getAtributo();
        System.out.println("Valor da String: " + stringValor);

        // Usando a classe genérica com um Integer
        GenericClass<Integer> intObj = new GenericClass<>(42);
        Integer intValor = intObj.getAtributo();
        System.out.println("Valor do Integer: " + intValor);

        // Usando a classe genérica com um objeto personalizado (por exemplo, uma classe Pessoa)
        Pessoa pessoa = new Pessoa("João", 30);
        GenericClass<Pessoa> pessoaObj = new GenericClass<>(pessoa);
        Pessoa pessoaValor = pessoaObj.getAtributo();
        System.out.println("Nome da Pessoa: " + pessoaValor.getNome());
        System.out.println("Idade da Pessoa: " + pessoaValor.getIdade());

        // Usando a classe genérica com um objeto do Java (por exemplo, uma data)
        GenericClass<java.util.Date> dateObj = new GenericClass<>(new java.util.Date());
        java.util.Date dateValue = dateObj.getAtributo();
        System.out.println("Valor da Data: " + dateValue);

        // Usando a classe genérica com um objeto do Java (por exemplo, um ArrayList)
        java.util.ArrayList<String> stringList = new java.util.ArrayList<>();
        stringList.add("Elemento 1");
        stringList.add("Elemento 2");
        GenericClass<java.util.ArrayList<String>> listObj = new GenericClass<>(stringList);
        java.util.ArrayList<String> listValue = listObj.getAtributo();
        System.out.println("Valor do ArrayList: " + listValue);

        MeuString meuString = new MeuString("Oi");
        GenericClass<MeuString> meuStringObj = new GenericClass<>(meuString);
        MeuString meuStringValue = meuStringObj.getAtributo();
        System.out.println("Valor de MeuString: " + meuStringValue.getStr());
}
}
