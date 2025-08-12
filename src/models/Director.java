package models;

public class Director extends Person {
    private final String estiloDirecao;

    public Director(String nome, int idade, String nacionalidade, String estiloDirecao) {
        super(nome, idade, nacionalidade);
        this.estiloDirecao = estiloDirecao;
    }

    @Override
    public void descreverPapel() {
        System.out.println(getNome() + " é o diretor com estilo: " + estiloDirecao);
    }
}
