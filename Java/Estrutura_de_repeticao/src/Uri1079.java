import java.util.Locale;
import java.util.Scanner;

public class Uri1079 {
    public static void main(String[] args) {
        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        int entries;
        double a, b, c, weightedAverage;

    
        //Entrada, processamento e saída de dados
        System.out.println("Type how many averages would you like to calculate?");
        entries = sc.nextInt();

        for (int i = 0; i < entries; i++) {
            System.out.println("Type three numbers:");

            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();

            weightedAverage = (a * 2 + b * 3 + c * 5) / 10;

            System.out.printf("The weighted average is: %.1f%n",  weightedAverage);
            System.out.println();
        }

        sc.close();
    }
}