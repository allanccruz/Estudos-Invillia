import java.util.Scanner;

public class Uri1046 {
    public static void main(String[] args) {

        //Objetos
        Scanner sc = new Scanner(System.in);

        //Váriaveis
        int horaInicial;
        int horaFinal;
        int duracao;

        //Entrada, processamento e saída de dados
        System.out.println("DIGITE A HORA DE INÍCIO DO JOGO:");
        horaInicial = sc.nextInt();

        System.out.println("DIGITE A HORA DE TÉRMINO DO JOGO:");
        horaFinal = sc.nextInt();

        if (horaInicial >= horaFinal) {
            duracao = 24 - horaInicial + horaFinal;
        } 
        else {
            duracao = horaFinal - horaInicial;
        }

        System.out.println("O JOGO DUROU " + duracao + " HORA(S)");

        sc.close();
    }
}
 
