import java.util.Scanner;
import java.util.Locale;

public class Uri1051 {
    public static void main(String[] args) {

        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        double salary, taxRate, tax;
        
        //Entrada, processamento e saída de dados
        System.out.println("How much is your monthly salary?");
        salary = sc.nextDouble();
        
        if (salary <= 2000) {
            tax = 0;
            System.out.printf("Your income tax is: R$ %.2f%n", tax);
        }
        else if (salary <= 3000) {
            taxRate = 0.08;
            tax = taxRate * (salary - 2000.01);
            System.out.printf("Your income tax is: R$ %.2f%n", tax);
        }
        else if (salary <= 4500) {
            taxRate = 0.18;
            tax = taxRate * (salary - 3000.01) + 0.08 * (3000 - 2000.01);
            System.out.printf("Your income tax is: R$ %.2f%n", tax);
        }
        else {
            taxRate = 0.28;
            tax = taxRate * (salary - 4500) + 0.08 * (3000 - 2000.01) + 0.18 * (4500 - 3000.01);
            System.out.printf("Your income tax is: R$ %.2f%n", tax);
        }

        sc.close();
    }
}
