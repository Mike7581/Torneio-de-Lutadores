package registro;

import java.util.Scanner;

public class Registro {
    String[] nomes = new String[8];
    String[] classes = new String[8];
    int[] ataques = new int[8];
    int[] defesas = new int[8];
    int[] agilidades = new int[8];
    int[] danos = new int[8];
    public void registrar() {

        Scanner in = new Scanner(System.in);

        System.out.println("Registro");
        System.out.println("Vamos criar um novo lutador(a)");

        for (int i = 0; i < 8; i++){

            System.out.println("Digite o nome do lutador(a) numero " + (i+1) + ":");
            nomes[i] = in.nextLine();

            while (
                            !classes[i].equalsIgnoreCase("Caça") &&
                            !classes[i].equalsIgnoreCase("Guerra") &&
                            !classes[i].equalsIgnoreCase("Estratégia") &&
                            !classes[i].equalsIgnoreCase("Magia")
            ){
                System.out.println("Classe inválida. Digite Caça, Guerra, Estratégia ou Magia:");
                classes[i] = in.nextLine();
            }



            System.out.println("Digite o ataque do lutador(a):");
            ataques[i] = in.nextInt();
            while(ataques[i] > 100 || ataques[i] < 0) {
                System.out.println("Digite um valor entre 0 e 100!");
                ataques[i] = in.nextInt();
            }



            System.out.println("Digite a defesa do lutador(a):");
            defesas[i] = in.nextInt();
            while(defesas[i] > 100 || defesas[i] < 0) {
                System.out.println("Digite um valor entre 0 e 100!");
                defesas[i] = in.nextInt();
            }



            System.out.println("Digite a agilidade do lutador(a):");
            agilidades[i] = in.nextInt();
            while(agilidades[i] > 100 || agilidades[i] < 0) {
                System.out.println("Digite um valor entre 0 e 100!");
                agilidades[i] = in.nextInt();
            }


            danos[i] = ataques[i] + defesas[i] + agilidades[i];


        }
    }
}
