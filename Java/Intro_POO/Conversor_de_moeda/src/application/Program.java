package application;

import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        CurrencyConverter converter = new CurrencyConverter();

        System.out.println("Whats the dollar price?");
        converter.dollarPrice = sc.nextDouble();

        System.out.println("How many dollars will be bought?");
        converter.dollarAmount = sc.nextDouble();

        System.out.printf("Amount to be paid in reais = R$ %.2f", converter.totalDollarPrice());
        sc.close();
    }
}
