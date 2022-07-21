import java.util.Scanner;
import java.util.Locale;

public class Uri1038 {
    public static void main(String[] args) {

        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        int id, amount;
        double price, total;

        //Entrada, processamento e saída de dados
        System.out.println("Type the code of the iten:");
        id = sc.nextInt();

        System.out.println("How many did you buy?");
        amount = sc.nextInt();

        price = 0;

        switch(id) {
            case 1:
                price = 4.00;
                break;
            case 2:
                price = 4.50;
                break;
            case 3:
                price = 5.00;
                break;
            case 4:
                price = 2.00;
                break;
            case 5:
                price = 1.50;  
                break;          
        }

        total = amount*price;

        System.out.printf("Total: R$ %.2f%n", total);
        
        sc.close();
    }
}
