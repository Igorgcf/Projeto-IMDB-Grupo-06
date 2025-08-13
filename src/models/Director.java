package models;

public class Director extends Person {

    private String drivingStyle;

    public Director(String name, int age, String nationality, String drivingStyle, String document) {
        super(name,  age, nationality, document);
        drivingStyle = drivingStyle;
    }

    public String getDrivingStyle() {
        return drivingStyle;
    }

    public void setDrivingStyle(String drivingStyle) {
        this.drivingStyle = drivingStyle;
    }
}
