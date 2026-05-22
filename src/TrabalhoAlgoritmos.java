import java.util.Scanner;

public class TrabalhoAlgoritmos {

    static final int MAX_LUTADORES = 8; // Quantidade máxima de lutadores

    static String[] nomes = new String[MAX_LUTADORES]; // Guarda os nomes dos lutadores
    static String[] classes = new String[MAX_LUTADORES]; // Guarda as classes dos lutadores
    static int[] ataques = new int[MAX_LUTADORES]; // Guarda os pontos de ataque
    static int[] defesas = new int[MAX_LUTADORES]; // Guarda os pontos de defesa
    static int[] agilidades = new int[MAX_LUTADORES]; // Guarda os pontos de agilidade
    static int[] danos = new int[MAX_LUTADORES]; // Guarda o dano total calculado
    static int[][] pontuacoes = new int[MAX_LUTADORES][3]; // Guarda a pontuação de cada lutador em 3 combates

    static int[][] lutas = { // Guarda os combates, usando os índices dos lutadores
            {3, 4}, {3, 5}, {1, 7}, {4, 5}, {6, 3}, {7, 0},
            {7, 5}, {1, 0}, {6, 4}, {2, 6}, {1, 2}, {0, 2}
    };

    static int totalCadastrados = 0; // Conta quantos lutadores foram cadastrados

    public static void main(String[] args) {
        System.out.println("Torneio de Lutadores!"); // Mensagem inicial do sistema
        Scanner in = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 9) { // Mantém o menu funcionando até o usuário escolher sair
            System.out.println("Escolha o que você quer fazer:");
            System.out.println("1 - Registrar lutadores(as)");
            System.out.println("2 - Mostrar lutadores(as)");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Listar por classe");
            System.out.println("5 - Mostrar combates");
            System.out.println("6 - Executar lutas");
            System.out.println("7 - Mostrar Pontuações");
            System.out.println("8 - Mostrar Ranking");
            System.out.println("9 - Sair");

            escolha = in.nextInt(); // Lê a opção escolhida
            in.nextLine(); // Limpa o buffer do teclado

            switch (escolha) { // Executa a opção escolhida no menu
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
                    mostrarCombates();
                    break;

                case 6:
                    executarLutas();
                    break;

                case 7:
                    mostrarPontuacao();
                    break;

                case 8:
                    mostrarRanking();
                    break;

                case 9:
                    System.out.println("Saindo...!");
                    break;

                case 10:
                    System.out.println("Debug Mode");
                    totalCadastrados = 8;
                    break;

                default:
                    System.out.println("Escolha inválida!"); // Mensagem para opção fora do menu
                    break;
            }
        }

        in.close(); // Fecha o Scanner
    }

    private static void registrar(Scanner in) { // Registra os lutadores
        if (totalCadastrados >= MAX_LUTADORES) { // Evita cadastrar mais do que o tamanho dos arrays
            System.out.println("Todos os lutadores já foram cadastrados.");
            return;
        }

        System.out.println("Registro");
        System.out.println("Vamos criar os lutadores(as)");

        for (int i = totalCadastrados; i < MAX_LUTADORES; i++) { // Cadastra até completar os 8 lutadores
            System.out.println("Digite o nome do lutador(a) número " + (i + 1) + ":");
            nomes[i] = in.nextLine();

            System.out.println("Digite a classe do lutador(a): Caça, Guerra, Estratégia ou Magia");
            classes[i] = in.nextLine();

            while (!classeValida(classes[i])) { // Valida a classe digitada
                System.out.println("Classe inválida. Digite Caça, Guerra, Estratégia ou Magia:");
                classes[i] = in.nextLine();
            }

            System.out.println("Digite o ataque do lutador(a):");
            System.out.println("Digite um valor entre 0 e 100!");
            ataques[i] = in.nextInt(); // Cadastra o ataque

            while (ataques[i] > 100 || ataques[i] < 0) { // Valida o ataque
                System.out.println("Digite um valor entre 0 e 100!");
                ataques[i] = in.nextInt();
            }

            System.out.println("Digite a defesa do lutador(a):");
            System.out.println("Digite um valor entre 0 e 100!");
            defesas[i] = in.nextInt(); // Cadastra a defesa

            while (defesas[i] > 100 || defesas[i] < 0) { // Valida a defesa
                System.out.println("Digite um valor entre 0 e 100!");
                defesas[i] = in.nextInt();
            }

            System.out.println("Digite a agilidade do lutador(a):");
            System.out.println("Digite um valor entre 0 e 100!");
            agilidades[i] = in.nextInt(); // Cadastra a agilidade

            while (agilidades[i] > 100 || agilidades[i] < 0) { // Valida a agilidade
                System.out.println("Digite um valor entre 0 e 100!");
                agilidades[i] = in.nextInt();
            }

            in.nextLine(); // Limpa o buffer do teclado

            danos[i] = ataques[i] + defesas[i] + agilidades[i]; // Calcula o dano total do lutador

            System.out.println("Lutador(a) " + nomes[i] + " registrado com sucesso!");
            System.out.println("Dano calculado: " + danos[i]);

            totalCadastrados++; // Aumenta a quantidade de cadastrados
        }
    }

    private static boolean classeValida(String classe) { // Verifica se a classe digitada é válida
        return classe.equalsIgnoreCase("Caça")
                || classe.equalsIgnoreCase("Caca")
                || classe.equalsIgnoreCase("Guerra")
                || classe.equalsIgnoreCase("Estratégia")
                || classe.equalsIgnoreCase("Estrategia")
                || classe.equalsIgnoreCase("Magia");
    }

    private static void mostrarLutadores() { // Mostra todos os lutadores cadastrados
        if (totalCadastrados == 0) { // Verifica se existe algum cadastro
            System.out.println("Nenhum lutador foi cadastrado ainda.");
            return; // Volta para o menu
        }

        System.out.println("Lutadores cadastrados:");
        System.out.println(" ");

        for (int i = 0; i < totalCadastrados; i++) { // Percorre todos os lutadores cadastrados
            System.out.println("-------------------------");
            System.out.println("Nome: " + nomes[i]);
            System.out.println("Classe: " + classes[i]);
            System.out.println("Ataque: " + ataques[i]);
            System.out.println("Defesa: " + defesas[i]);
            System.out.println("Agilidade: " + agilidades[i]);
            System.out.println("Dano: " + danos[i]);
        }
    }

    private static void buscarPorNome(Scanner in) { // Busca um lutador pelo nome
        System.out.println("Digite o nome do lutador que deseja buscar:");
        String nome = in.nextLine();

        boolean encontrou = false; // Controla se algum lutador foi encontrado

        for (int i = 0; i < totalCadastrados; i++) { // Percorre os lutadores cadastrados
            if (nomes[i].equalsIgnoreCase(nome)) { // Compara o nome digitado com os nomes cadastrados
                System.out.println("Lutador(a) " + nomes[i] + " encontrado!");
                System.out.println(" ");
                System.out.println("Status:");
                System.out.println("Nome: " + nomes[i]);
                System.out.println("Classe: " + classes[i]);
                System.out.println("Ataque: " + ataques[i]);
                System.out.println("Defesa: " + defesas[i]);
                System.out.println("Agilidade: " + agilidades[i]);
                System.out.println("Dano: " + danos[i]);

                encontrou = true; // Marca que encontrou o lutador
            }
        }

        if (!encontrou) { // Mostra mensagem caso nenhum lutador seja encontrado
            System.out.println("Nenhum lutador com esse nome foi encontrado.");
        }
    }

    private static void listarPorClasse(Scanner in) { // Lista os lutadores de uma classe específica
        System.out.println("Digite a classe que deseja ver os lutadores:");
        String classe = in.nextLine();

        while (!classeValida(classe)) { // Valida a classe digitada
            System.out.println("Classe inválida. Digite Caça, Guerra, Estratégia ou Magia:");
            classe = in.nextLine();
        }

        System.out.println("Lutadores da classe " + classe + ":");

        boolean encontrou = false; // Controla se encontrou algum lutador da classe

        for (int i = 0; i < totalCadastrados; i++) { // Percorre os lutadores cadastrados
            if (classes[i].equalsIgnoreCase(classe)) { // Verifica se a classe é igual à pesquisada
                System.out.println(nomes[i]);
                encontrou = true;
            }
        }

        if (!encontrou) { // Mostra mensagem se nenhum lutador for encontrado
            System.out.println("Nenhum lutador encontrado nessa classe.");
        }
    }

    private static void mostrarCombates(){ // Mostra todos os combates definidos
        System.out.println("Os Lutadores serão: ");

        if (totalCadastrados < MAX_LUTADORES) { // Verifica se todos os lutadores foram cadastrados
            System.out.println("Nem todos os lutadores foram cadastrados.");
        }
        else {
            for (int i = 0; i < lutas.length; i++) { // Percorre todas as lutas
                System.out.println(nomes[lutas[i][0]] + " vs " + nomes[lutas[i][1]]);
            }
        }
    }

    private static void executarLutas(){ // Executa todas as lutas e preenche a matriz de pontuações
        if (totalCadastrados < MAX_LUTADORES) { // Verifica se todos os lutadores foram cadastrados
            System.out.println("Nem todos os lutadores foram cadastrados.");
            return; // Volta para o menu
        }

        int[] combatesFeitos = new int[MAX_LUTADORES]; // Conta quantos combates cada lutador já fez

        for (int i = 0; i < MAX_LUTADORES; i++) { // Percorre todos os lutadores
            for (int j = 0; j < 3; j++) { // Percorre os 3 combates de cada lutador
                pontuacoes[i][j] = 0; // Zera a pontuação antes de executar as lutas
            }
        }

        System.out.println("Vamos lutar!");

        for (int i = 0; i < lutas.length; i++) { // Percorre todas as lutas cadastradas
            int lutador1 = lutas[i][0]; // Guarda o índice do primeiro lutador
            int lutador2 = lutas[i][1]; // Guarda o índice do segundo lutador

            int pontos1; // Guarda os pontos do primeiro lutador
            int pontos2; // Guarda os pontos do segundo lutador

            if (danos[lutador1] > danos[lutador2]) { // Verifica se o primeiro lutador venceu
                pontos1 = 3;
                pontos2 = 0;
            } else if (danos[lutador2] > danos[lutador1]) { // Verifica se o segundo lutador venceu
                pontos1 = 0;
                pontos2 = 3;
            } else { // Caso os danos sejam iguais, considera empate
                pontos1 = 1;
                pontos2 = 1;
            }

            pontuacoes[lutador1][combatesFeitos[lutador1]] = pontos1; // Salva os pontos do primeiro lutador
            pontuacoes[lutador2][combatesFeitos[lutador2]] = pontos2; // Salva os pontos do segundo lutador

            combatesFeitos[lutador1]++; // Aumenta a quantidade de combates feitos pelo primeiro lutador
            combatesFeitos[lutador2]++; // Aumenta a quantidade de combates feitos pelo segundo lutador

            System.out.println(nomes[lutador1] + " " + pontos1 + " x " + pontos2 + " " + nomes[lutador2]);
        }

        System.out.println("Lutas executadas com sucesso!");
    }

    private static void mostrarPontuacao(){ // Mostra a pontuação de cada lutador
        if(totalCadastrados < MAX_LUTADORES){
            System.out.println("Nem todos os lutadores foram cadastrados.");
        }else{
            System.out.println("A pontuação final é: ");

            for (int i = 0; i < totalCadastrados; i++) { // Percorre todos os lutadores cadastrados
                System.out.println("-------------------------");
                System.out.println("Nome: " + nomes[i]);
                System.out.println("Combate 1: " + pontuacoes[i][0]);
                System.out.println("Combate 2: " + pontuacoes[i][1]);
                System.out.println("Combate 3: " + pontuacoes[i][2]);
            }
        }
    }

    private static void mostrarRanking(){ // Mostra o ranking final
        System.out.println("O ranking final foi: ");
        System.out.println("Finalista 1: ");
        System.out.println("Finalista 2: ");
        System.out.println("Finalista 3: ");
    }
}

/*
Talysson Aguinario
Isabeli Souza
*/