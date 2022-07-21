import java.util.Scanner;

public class Uri1143 {
    public static void main(String[] args) {
        //Objetos
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        int number;
    
        //Entrada, processamento e saída de dados
        System.out.println("Type a number:");
        number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            System.out.printf(i + " %.0f %.0f", Math.pow(i, 2), Math.pow(i, 3));
            System.out.println();
        }

        sc.close();
    }
}
