import java.util.Scanner;

public class Uri1134 {
    public static void main(String[] args) {

        //Objetos
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        int fuelCode, contEthanol, contGas, contDiesel;
    
        //Entrada, processamento e saída de dados

        contEthanol = 0;
        contGas = 0;
        contDiesel = 0;

        do {
            System.out.println("What type of fuel do you use?");
            System.out.println("  1. Ethanol");
            System.out.println("  2. Gas");
            System.out.println("  3. Diesel");
            System.out.println("  4. Close program");
            fuelCode = sc.nextInt();
            
            switch(fuelCode) {
                case 1:
                    contEthanol = contEthanol + 1;
                    break;
                case 2:
                    contGas = contGas + 1;
                    break;
                case 3:
                    contDiesel = contDiesel + 1;
                    break;         
            }

        } while (fuelCode != 4);

        System.out.println("THANK YOU FOR YOUR TIME!");
        System.out.println();
        System.out.println("Ethanol: " + contEthanol);
        System.out.println("Gas: " + contGas);
        System.out.println("Diesel: " + contDiesel);

        sc.close();
    }
}