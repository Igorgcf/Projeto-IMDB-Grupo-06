package models;

public abstract class Person {
    private String name;
    private int age;
    private String nationality;
    private String document;

    public Person(String name, int age, String nationality, String document) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.document = document;
    }

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
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getByDocument(String document) {
        return this.document.contains(document) ? this.document : null ;
    }
}
