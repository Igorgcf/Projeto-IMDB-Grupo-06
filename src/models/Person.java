package models;

public abstract class Person {
    private String name;
    private int age;
    private String Nationality;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.Nationality = nationality;


    }


    // Método comum
    public void exibirInfo() {
        System.out.println("Nome: " + name);
        System.out.println("Idade: " + age );
        System.out.println("Nacionalidade: " + Nationality);
    }

    // Método abstrato — cada tipo de Persona define seu papel
    public abstract void descreverPapel();
}
