package entities;

public class Student {
    //Atributos da classe
    public String name;
    public double grade1;
    public double grade2;
    public double grade3;

    //Métodos da classe
    public double finalGrade (){
        return grade1 + grade2 + grade3;
    }
    public double missingPoints(){
        return 60 - finalGrade();
    }
}
