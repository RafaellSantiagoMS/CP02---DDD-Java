import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static Entregador[] entregadores = new Entregador[10];
    static Entrega[] entregas = new Entrega[10];

    static int totalEntregadores = 0;
    static int totalEntregas = 0;

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n======= SISTEMA DE LOGÍSTICA =======");
            System.out.println("1 - Cadastrar entregador");
            System.out.println("2 - Criar entrega");
            System.out.println("3 - Listar entregadores");
            System.out.println("4 - Listar entregas");
            System.out.println("5 - Atribuir entrega");
            System.out.println("6 - Atualizar status");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEntregador();
                    break;
                case 2:
                    criarEntrega();
                    break;
                case 3:
                    listarEntregadores();
                    break;
                case 4:
                    listarEntregas();
                    break;
                case 5:
                    atribuirEntrega();
                    break;
                case 6:
                    atualizarStatus();
                    break;
                case 0:
                    System.out.println("Sistema finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void cadastrarEntregador() {

        System.out.print("ID do entregador: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < totalEntregadores; i++) {
            if (entregadores[i].getId() == id) {
                System.out.println("Já existe um entregador com esse ID.");
                return;
            }
        }

        System.out.print("Nome do entregador: ");
        String nome = sc.nextLine();

        System.out.println("Tipo:");
        System.out.println("1 - Moto");
        System.out.println("2 - Bicicleta");
        System.out.print("Escolha: ");
        int tipo = sc.nextInt();

        if (tipo == 1) {
            entregadores[totalEntregadores] = new EntregadorMoto(id, nome);
            totalEntregadores++;
            System.out.println("Entregador de moto cadastrado!");
        } else if (tipo == 2) {
            entregadores[totalEntregadores] = new EntregadorBicicleta(id, nome);
            totalEntregadores++;
            System.out.println("Entregador de bicicleta cadastrado!");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    public static void criarEntrega() {

        System.out.print("ID da entrega: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < totalEntregas; i++) {
            if (entregas[i].getId() == id) {
                System.out.println("Já existe uma entrega com esse ID.");
                return;
            }
        }

        System.out.print("Endereço de destino: ");
        String endereco = sc.nextLine();

        System.out.print("Distância em km: ");
        double distancia = sc.nextDouble();

        entregas[totalEntregas] = new Entrega(id, endereco, distancia);
        totalEntregas++;

        System.out.println("Entrega criada com sucesso!");
    }

    public static void listarEntregadores() {

        if (totalEntregadores == 0) {
            System.out.println("Nenhum entregador cadastrado.");
            return;
        }

        for (int i = 0; i < totalEntregadores; i++) {
            System.out.println("\n--- Entregador ---");
            entregadores[i].mostrarDados();
        }
    }

    public static void listarEntregas() {

        if (totalEntregas == 0) {
            System.out.println("Nenhuma entrega cadastrada.");
            return;
        }

        for (int i = 0; i < totalEntregas; i++) {
            System.out.println("\n--- Entrega ---");
            entregas[i].mostrarEntrega();
        }
    }

    public static void atribuirEntrega() {

        System.out.print("ID da entrega: ");
        int idEntrega = sc.nextInt();

        System.out.print("ID do entregador: ");
        int idEntregador = sc.nextInt();

        Entrega entregaEncontrada = null;
        Entregador entregadorEncontrado = null;

        for (int i = 0; i < totalEntregas; i++) {
            if (entregas[i].getId() == idEntrega) {
                entregaEncontrada = entregas[i];
            }
        }

        for (int i = 0; i < totalEntregadores; i++) {
            if (entregadores[i].getId() == idEntregador) {
                entregadorEncontrado = entregadores[i];
            }
        }

        if (entregaEncontrada != null && entregadorEncontrado != null) {
            entregaEncontrada.atribuirEntregador(entregadorEncontrado);
        } else {
            System.out.println("Entrega ou entregador não encontrado.");
        }
    }

    public static void atualizarStatus() {

        System.out.print("ID da entrega: ");
        int idEntrega = sc.nextInt();
        sc.nextLine();

        Entrega entregaEncontrada = null;

        for (int i = 0; i < totalEntregas; i++) {
            if (entregas[i].getId() == idEntrega) {
                entregaEncontrada = entregas[i];
            }
        }

        if (entregaEncontrada == null) {
            System.out.println("Entrega não encontrada.");
            return;
        }

        System.out.println("Escolha o novo status:");
        System.out.println("1 - Pendente");
        System.out.println("2 - Em rota");
        System.out.println("3 - Entregue");
        System.out.println("4 - Cancelada");
        System.out.print("Escolha: ");

        int opcaoStatus = sc.nextInt();
        sc.nextLine();

        String status = "";

        if (opcaoStatus == 1) {
            status = "Pendente";
        } else if (opcaoStatus == 2) {
            status = "Em rota";
        } else if (opcaoStatus == 3) {
            status = "Entregue";
        } else if (opcaoStatus == 4) {
            status = "Cancelada";
        } else {
            System.out.println("Status inválido.");
            return;
        }

        System.out.print("Deseja adicionar observação? (s/n): ");
        String resposta = sc.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite a observação: ");
            String observacao = sc.nextLine();
            entregaEncontrada.atualizarStatus(status, observacao);
        } else {
            entregaEncontrada.atualizarStatus(status);
        }

        System.out.println("Status atualizado com sucesso!");
    }
}