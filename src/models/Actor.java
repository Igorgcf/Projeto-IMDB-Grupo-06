package models;

public class Actor extends Person {
    private final String personagem;

    public Actor(String nome, int idade, String nacionalidade, String personagem) {
        super(nome, idade, nacionalidade);
        this.personagem = personagem;
    }

    public void descreverPapel() {
        System.out.println(getNome() + " interpreta o personagem: " + personagem);
    }
}