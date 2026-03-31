package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProvaService {
    private final List<Prova> provas = new ArrayList<>();
    private final List<Questao> questoes = new ArrayList<>();
    private long proximaProvaId = 1;
    private long proximaQuestaoId = 1;
    private final Scanner in;

    public ProvaService(Scanner in) {
        this.in = in;
    }

    public void cadastrar() {
        System.out.print("Título da prova: ");
        var titulo = in.nextLine();
        if (titulo.isBlank()) return;

        var prova = new Prova();
        prova.setId(proximaProvaId++);
        prova.setTitulo(titulo);
        provas.add(prova);
        System.out.println("Prova criada: " + prova.getId());
    }

    public void adicionarQuestao() {
        Long provaId = escolherId();
        if (provaId == null) return;

        System.out.println("Enunciado:");
        var enunciado = in.nextLine();

        var alternativas = new String[5];
        for (int i = 0; i < 5; i++) {
            char letra = (char) ('A' + i);
            System.out.print("Alternativa " + letra + ": ");
            alternativas[i] = letra + ") " + in.nextLine();
        }

        System.out.print("Alternativa correta (A–E): ");
        char correta;
        try {
            correta = Questao.normalizar(in.nextLine().trim().charAt(0));
        } catch (Exception e) { return; }

        var q = new Questao();
        q.setId(proximaQuestaoId++);
        q.setProvaId(provaId);
        q.setEnunciado(enunciado);
        q.setAlternativas(alternativas);
        q.setAlternativaCorreta(correta);

        questoes.add(q);
    }

    public Long escolherId() {
        if (provas.isEmpty()) return null;
        provas.forEach(p -> System.out.printf("  %d) %s%n", p.getId(), p.getTitulo()));
        System.out.print("Escolha o ID da prova: ");
        try {
            long id = Long.parseLong(in.nextLine());
            return provas.stream().anyMatch(p -> p.getId() == id) ? id : null;
        } catch (Exception e) { return null; }
    }

    public List<Questao> getQuestoes() { return questoes; }
}