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
        System.out.println();

        for (int i = 0; i < person.length; i++) {
            System.out.println("Insert person's data:");
            System.out.print("Name: ");
            sc.nextLine(); //só pra consumir a quebra de linha pendende do sc.nextInt();
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            System.out.print("Height: ");
            double height = sc.nextDouble();
            System.out.println();

            person[i] = new Person(name, age, height);
        }

        double sum = 0.0;
        for (Person obj : person) {
            sum += obj.getHeight();
        }
        double avg = sum / person.length;
        System.out.printf("Average height: %.2f\n", avg);

        int count = 0;
        for (Person obj : person) {
            if (obj.getAge() < 16) {
                count++;
            }
        }
        double percentage = count * 100.0 / person.length;
        System.out.printf("Percentage of people under 16 years old: %.1f%%\n", percentage);

        for (Person obj : person) {
            if (obj.getAge() < 16) {
                System.out.println(obj.getName());
            }
        }

        sc.close();
    }
}
