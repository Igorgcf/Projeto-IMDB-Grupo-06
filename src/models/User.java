package models;

public class User extends Person{

    private String email;
    public User(String name,  int age, String nationality, String document, String email) {
        super(name,  age, nationality, document);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
