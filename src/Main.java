import java.util.Scanner;
import registro.Registro;


public class Main {
    public static void main(String[] args) {
        System.out.println("Torneio de Lutadores!");

        Scanner in = new Scanner(System.in);
        Registro registro = new Registro();
        int escolha = 0;

        while(escolha != 5){
            System.out.println("Escolhe oque voce quer fazer:");
            System.out.println("1 - Registrar lutadores(as)");
            System.out.println("2 - Mostrar lutadores(as)");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Listar por classe");
            System.out.println("5 - Sair");
            escolha = in.nextInt();
            switch (escolha){
                case 1:
                    System.out.println("Registrar lutadores(as)");
                    registro.registrar();
                    break;
                case 2:
                    System.out.println("2 - Mostrar lutadores(as)");
                    break;
                case 3:
                    System.out.println("3 - Buscar por nome");
                    break;
                case 4:
                    System.out.println("4 - Listar por classe");
                    break;
                case 5:
                    System.out.println("Saindo...!");
                    break;
                default:
                    System.out.println("Escolha invalida!");
                    break;
            }

        }
    }
}
