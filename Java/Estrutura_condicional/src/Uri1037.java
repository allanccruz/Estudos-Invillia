import java.util.Scanner;
import java.util.Locale;

public class Uri1037 {
    public static void main(String[] args) {

        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        double number;


        //Entrada, processamento e saída de dados
        System.out.print("Type a number: ");
        number = sc.nextDouble();


        if (number < 0  || number > 100){
            System.out.println("Out of range");
        } 
        else if (number <= 25){
            System.out.println("Range [0, 25]");
        } 
        else if (number <= 50) {
            System.out.println("Range (25, 50]");
        }
        else if (number <= 75) {
            System.out.println("Range (50, 75]");
        }
        else {
            System.out.println("Range (75, 100]");
        }
        
        sc.close();
    }
    
}
