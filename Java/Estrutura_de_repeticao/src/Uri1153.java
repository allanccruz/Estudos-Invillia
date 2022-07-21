import java.util.Scanner;

public class Uri1153 {
    public static void main(String[] args) {

        //Objetos
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        int number, factorial;
    
        //Entrada, processamento e saída de dados
        System.out.println("Type a number to calculete its factorial:");
        number = sc.nextInt();

        factorial = 1;

        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        
        System.out.println("The factorial of " + number + " is: " + factorial);

        sc.close();
    }
}