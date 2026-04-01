package br.com.ucsal.olimpiadas;
import java.util.Scanner;

public class App {
    // 1. O Scanner é criado apenas uma vez
    private static final Scanner in = new Scanner(System.in);

    // 2. instaciaçao do static para usar em toda classe, evitando criar várias vezes
    private static final ParticipanteService pService = new ParticipanteService(in);
    private static final ProvaService prService = new ProvaService(in);
    private static final ExecucaoService eService = new ExecucaoService(in);

    public static void main(String[] args) {
   
        seed(); 

        while (true) {
            exibirMenu();
            String opcao = in.nextLine();

            switch (opcao) {
                case "1" -> pService.cadastrar();
                case "2" -> prService.cadastrar();
                case "3" -> prService.adicionarQuestao();
                case "4" -> eService.aplicarProva(pService, prService); // Passa os serviços necessários
                case "5" -> eService.listarTentativas();
                case "0" -> {
                    System.out.println("Saindo do sistema... Até logo!");
                    return;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== OLIMPÍADA DE QUESTÕES (V1) ===");
        System.out.println("1) Cadastrar participante");
        System.out.println("2) Cadastrar prova");
        System.out.println("3) Cadastrar questão em uma prova");
        System.out.println("4) Aplicar prova");
        System.out.println("5) Listar tentativas (resumo)");
        System.out.println("0) Sair");
        System.out.print("> ");
    }

    // Método para popular o sistema com dados iniciais (facilitando os testes)
    private static void seed() {
        System.out.println("Carregando dados iniciais...");
       
    }
}