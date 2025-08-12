package models;

public class Director extends Person {
    public Director(String name,  int age, String nationality, String drivingstyle) {
        super(name,  age, nationality);
        Drivingstyle = drivingstyle;
    }

    private final String Drivingstyle;



    @Override
    public void descreverPapel() {
        System.out.println(getName() + " é o diretor com estilo: " + Drivingstyle);
    }
}
