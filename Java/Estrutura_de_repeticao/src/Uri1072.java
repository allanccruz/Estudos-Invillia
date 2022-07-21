import java.util.Locale;
import java.util.Scanner;

public class Uri1072 {
    public static void main(String[] args) {
        //Objetos
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        int entries, in, out;
        double number;

    
        //Entrada, processamento e saída de dados
        System.out.println("How many numbers do you want to type?");
        entries = sc.nextInt();

        System.out.println("Type " + entries + " numbers:");

        in = 0;
        out = 0;

        for (int i = 0; i < entries; i++) {
            number = sc.nextDouble();
            
            if (number >= 10 && number <= 20) {
                in += 1;
            } 
            else {
                out += 1;
            }
        }

        System.out.println(in + " in [10,20]");
        System.out.println(out + " out [10,20]");

        sc.close();
    }
}
