package application;

import entities.User;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        User user;

        System.out.print("Enter account number: ");
        int accountId = sc.nextInt();

        System.out.print("Enter account holder: ");
        sc.nextLine();
        String accountHolderName = sc.nextLine();

        System.out.print("Is there an initial deposit (y/n)? ");
        char isThereInitialDeposit = Character.toLowerCase(sc.next().charAt(0));
        if (isThereInitialDeposit == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            user = new User(accountHolderName, accountId, initialDeposit);
        }
        else {
            user = new User(accountHolderName, accountId);
        }

        System.out.println();
        System.out.println("Account data: ");
        System.out.println(user);
        System.out.println();

        System.out.print("Enter a deposit value: ");
        user.deposit(sc.nextDouble());
        System.out.println("Updated account data: ");
        System.out.println(user);
        System.out.println();

        System.out.print("Enter a withdraw value: ");
        user.withdraw(sc.nextDouble());
        System.out.println("Updated account data: ");
        System.out.println(user);

    sc.close();
    }
}
