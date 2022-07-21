package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many people will you register? ");
        int n = sc.nextInt();

        Person[] person = new Person[n];

        for (int i = 0; i < person.length; i++) {
            System.out.print("Person's height: ");
            double height = sc.nextDouble();
            System.out.print("Person's gender: ");
            char gender = Character.toUpperCase(sc.next().charAt(0));
            person[i] = new Person(height, gender);
            System.out.println();
        }

        double minorHeight = Double.MAX_VALUE;
        double majorHeight = Double.MIN_VALUE;
        for (Person obj : person) {
            if (obj.getHeight() < minorHeight) {
                minorHeight = obj.getHeight();
            }

            if (obj.getHeight() > majorHeight) {
                majorHeight = obj.getHeight();
            }
        }

        System.out.printf("Minor height = %.2f\n", minorHeight);
        System.out.printf("Major height = %.2f\n", majorHeight);

        double sum = 0.0;
        int countF = 0;
        for (Person obj : person) {
            if (obj.getGender() == 'F') {
                sum += obj.getHeight();
                countF++;
            }
        }
        double avgFHeight = sum / countF;
        System.out.printf("Average female height = %.2f\n", avgFHeight);

        int countM = 0;
        for (Person obj : person) {
            if (obj.getGender() == 'M') {
                countM++;
            }
        }

        System.out.printf("Number of men = %d\n", countM);

        sc.close();
    }
}
