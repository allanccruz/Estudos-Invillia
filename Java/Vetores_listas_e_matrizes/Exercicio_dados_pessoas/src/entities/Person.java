package entities;

public class Person {

    private char gender;
    private double height;

    public Person(double height, char gender) {
        this.height = height;
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }
}
