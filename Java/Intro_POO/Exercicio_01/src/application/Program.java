package application;

import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        Rectangle rectangle;
        rectangle = new Rectangle();

        //Entrada, processamento e saída de dados
        System.out.println("Enter the rectangle width: ");
        rectangle.width = sc.nextDouble();

        System.out.println("Enter the rectangle height: ");
        rectangle.height = sc.nextDouble();

        System.out.print("AREA: " + rectangle.area());
        System.out.println();

        System.out.print("PERIMETER: " + rectangle.perimeter());
        System.out.println();

        System.out.print("DIAGONAL: " + rectangle.diagonal());

        sc.close();
    }
}