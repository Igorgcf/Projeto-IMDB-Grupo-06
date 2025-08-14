package models;

import java.util.List;

public class Actor extends Person {
    private List<String> characters;

    public Actor(String name, int age, String nationality, String document) {
        super(name,  age, nationality, document);
    }

    public List<String> getAllCharacters() {
        return characters;
    }

    public void addCharacter(String character) {
        characters.add(character);
    }

    public void removeCharacter(String character) {
        characters.remove(character);
    }

}