package entities;

public class Rectangle {
    //Atributos da classe
    public double width;
    public double height;

    //Métodos da classe
    public double area () {
        return width * height;
    };
    public double perimeter () {
        return 2 * (width + height);
    };
    public double diagonal () {
        return Math.sqrt((width * width + height * height));
    };
}
