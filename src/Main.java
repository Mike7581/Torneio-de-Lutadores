import java.util.Scanner;

public class Main {

    static String[] nomes = new String[8];
    static String[] classes = new String[8];
    static int[] ataques = new int[8];
    static int[] defesas = new int[8];
    static int[] agilidades = new int[8];
    static int[] danos = new int[8];

    static int totalCadastrados = 0;

    public static void main(String[] args) {
        System.out.println("Torneio de Lutadores!");

        Scanner in = new Scanner(System.in);

        int escolha = 0;

        while (escolha != 5) {
            System.out.println("Escolhe o que voce quer fazer:");
            System.out.println("1 - Registrar lutadores(as)");
            System.out.println("2 - Mostrar lutadores(as)");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Listar por classe");
            System.out.println("5 - Sair");

            escolha = in.nextInt();
            in.nextLine();

            switch (escolha) {
                case 1:
                    registrar(in);
                    break;

                case 2:
                    mostrarLutadores();
                    break;

                case 3:
                    buscarPorNome(in);
                    break;

                case 4:
                    listarPorClasse(in);
                    break;

                case 5:
                    System.out.println("Saindo...!");
                    break;

                default:
                    System.out.println("Escolha invalida!");
                    break;
            }
        }

        in.close();
    }

    private static void registrar(Scanner in) {
        System.out.println("Registro");
        System.out.println("Vamos criar os lutadores(as)");

        for (int i = 0; i < 8; i++) {
            System.out.println("Digite o nome do lutador(a) numero " + (i + 1) + ":");
            nomes[i] = in.nextLine();

            System.out.println("Digite a classe do lutador(a): Caça, Guerra, Estratégia ou Magia");
            classes[i] = in.nextLine();

            while (
                    !classes[i].equalsIgnoreCase("Caça") &&
                            !classes[i].equalsIgnoreCase("Guerra") &&
                            !classes[i].equalsIgnoreCase("Estratégia") &&
                            !classes[i].equalsIgnoreCase("Magia")
            ) {
                System.out.println("Classe inválida. Digite Caça, Guerra, Estratégia ou Magia:");
                classes[i] = in.nextLine();
            }

            System.out.println("Digite o ataque do lutador(a):");
            System.out.println("Digite um valor entre 0 e 100!");
            ataques[i] = in.nextInt();

            while (ataques[i] > 100 || ataques[i] < 0) {
                System.out.println("Digite um valor entre 0 e 100!");
                ataques[i] = in.nextInt();
            }

            System.out.println("Digite a defesa do lutador(a):");
            System.out.println("Digite um valor entre 0 e 100!");
            defesas[i] = in.nextInt();

            while (defesas[i] > 100 || defesas[i] < 0) {
                System.out.println("Digite um valor entre 0 e 100!");
                defesas[i] = in.nextInt();
            }

            System.out.println("Digite a agilidade do lutador(a):");
            System.out.println("Digite um valor entre 0 e 100!");
            agilidades[i] = in.nextInt();

            while (agilidades[i] > 100 || agilidades[i] < 0) {
                System.out.println("Digite um valor entre 0 e 100!");
                agilidades[i] = in.nextInt();
            }

            in.nextLine();

            danos[i] = ataques[i] + defesas[i] + agilidades[i];

            System.out.println("Lutador(a) " + nomes[i] + " registrado com sucesso!");
            System.out.println("Dano calculado: " + danos[i]);

            totalCadastrados++;
        }
    }

    private static void mostrarLutadores() {
        if (totalCadastrados == 0) {
            System.out.println("Nenhum lutador foi cadastrado ainda.");
            return;
        }

        System.out.println("Lutadores cadastrados:");
        System.out.println(" ");

        for (int i = 0; i < totalCadastrados; i++) {
            System.out.println("-------------------------");
            System.out.println("Nome: " + nomes[i]);
            System.out.println("Classe: " + classes[i]);
            System.out.println("Ataque: " + ataques[i]);
            System.out.println("Defesa: " + defesas[i]);
            System.out.println("Agilidade: " + agilidades[i]);
            System.out.println("Dano: " + danos[i]);
        }
    }

    private static void buscarPorNome(Scanner in) {
        System.out.println("Digite o nome do lutador que deseja buscar:");
        String nome = in.nextLine();

        boolean encontrou = false;

        for (int i = 0; i < totalCadastrados; i++) {
            if (nomes[i].equalsIgnoreCase(nome)) {
                System.out.println("Lutador(a) " + nomes[i] + " encontrado!");
                System.out.println(" ");
                System.out.println("Status:");
                System.out.println("Nome: " + nomes[i]);
                System.out.println("Classe: " + classes[i]);
                System.out.println("Ataque: " + ataques[i]);
                System.out.println("Defesa: " + defesas[i]);
                System.out.println("Agilidade: " + agilidades[i]);
                System.out.println("Dano: " + danos[i]);

                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum lutador com esse nome foi encontrado.");
        }
    }

    private static void listarPorClasse(Scanner in) {
        System.out.println("Digite a classe que deseja ver os lutadores:");
        String classe = in.nextLine();

        System.out.println("Lutadores da classe " + classe + ":");

        boolean encontrou = false;

        for (int i = 0; i < totalCadastrados; i++) {
            if (classes[i].equalsIgnoreCase(classe)) {
                System.out.println(nomes[i]);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum lutador encontrado nessa classe.");
        }
    }
}


/*
Talysson Aguinario
Isabeli Souza
Arthur Zanferari
*/