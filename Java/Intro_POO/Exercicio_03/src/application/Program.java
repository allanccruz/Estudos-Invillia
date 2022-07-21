package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        Student student;
        student = new Student();

        //Entrada, processamento e saída de dados
        System.out.println("Name: ");
        student.name = sc.nextLine();

        System.out.println("Type the grades 1, 2 and 3: ");
        student.grade1 = sc.nextDouble();
        student.grade2 = sc.nextDouble();
        student.grade3 = sc.nextDouble();

        System.out.printf("FINAL GRADE: %.2f\n", student.finalGrade());

        if (student.finalGrade() >= 60) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS", student.missingPoints());
        }

        sc.close();
    }
}
