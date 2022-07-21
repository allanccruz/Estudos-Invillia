package application;

import entities.Rent;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rooms will be rented? ");
        int n = sc.nextInt();

        Rent[] rented = new Rent[10];

        for (int i = 0; i < n; i++) {
            System.out.println("Rent #" + (i+1) +":");
            System.out.print("Name: ");
            sc.nextLine();
            String studentName = sc.nextLine();
            System.out.print("Email: ");
            String studentEmail = sc.next();
            System.out.print("Room: ");
            int roomNumber = sc.nextInt();

            if (rented[roomNumber - 1] == null) {
                rented[roomNumber - 1] = new Rent(roomNumber, studentName, studentEmail);
            }
            else {
                System.out.println("Room already occupied, choose another room for " + studentName + "and reset the program.");
                System.exit(0);
            }
            System.out.println();
        }

        System.out.println("Busy rooms:");
        for (Rent room : rented) {
            if (room != null) {
                System.out.println(room);
            }
        }

        sc.close();
    }
}

