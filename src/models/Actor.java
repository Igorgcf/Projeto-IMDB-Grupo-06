package models;

public class Actor extends Person {
    private final String character;

    public Actor(String name,  int age, String nationality, String character) {
        super(name,  age, nationality);
        this.character = character;
    }

    public void descreverPapel() {
        System.out.println(getName() + " interpreta o personagem: " + character);
    }
}