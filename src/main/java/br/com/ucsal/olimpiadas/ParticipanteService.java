package br.com.ucsal.olimpiadas;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParticipanteService {
    private final List<Participante> participantes = new ArrayList<>();
    private long proximoId = 1;
    private final Scanner in;

    public ParticipanteService(Scanner in) {
        this.in = in;
    }

    public void cadastrar() {
        System.out.print("Nome: ");
        var nome = in.nextLine();
        System.out.print("Email (opcional): ");
        var email = in.nextLine();

        if (nome == null || nome.isBlank()) {
            System.out.println("Erro: nome inválido");
            return;
        }

        var p = new Participante();
        p.setId(proximoId++);
        p.setNome(nome);
        p.setEmail(email);

        participantes.add(p);
        System.out.println("Participante cadastrado: " + p.getId());
    }

    public Long escolherId() {
        if (participantes.isEmpty()) {
            System.out.println("Não há participantes cadastrados.");
            return null;
        }
        System.out.println("\nParticipantes:");
        participantes.forEach(p -> System.out.printf("  %d) %s%n", p.getId(), p.getNome()));
        System.out.print("Escolha o ID: ");
        try {
            long id = Long.parseLong(in.nextLine());
            return participantes.stream().anyMatch(p -> p.getId() == id) ? id : null;
        } catch (Exception e) { return null; }
    }

    public List<Participante> getParticipantes() { return participantes; }
}