package br.com.ucsal.olimpiadas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExecucaoService {
    private final List<Tentativa> tentativas = new ArrayList<>();
    private long proximaTentativaId = 1;
    private final Scanner in;

    public ExecucaoService(Scanner in) {
        this.in = in;
    }

    public void aplicarProva(ParticipanteService pServ, ProvaService prServ) {
        Long pId = pServ.escolherId();
        // Verificação de segurança para evitar NullPointer
        if (pId == null) return; 

        Long prId = prServ.escolherId();
        if (prId == null) return;

        var questoes = prServ.getQuestoes().stream()
                .filter(q -> q.getProvaId().equals(prId)) // Uso de .equals para objetos Long
                .toList();

        if (questoes.isEmpty()) {
            System.out.println("Esta prova não possui questões cadastradas.");
            return;
        }

        Tentativa tentativa = new Tentativa();
        tentativa.setId(proximaTentativaId++);
        tentativa.setParticipanteId(pId);
        tentativa.setProvaId(prId);

        for (Questao q : questoes) {
            System.out.println("\n" + q.getEnunciado());
            
            for (String alt : q.getAlternativas()) {
                System.out.println(alt);
            }

            System.out.print("Sua resposta: ");
            String entrada = in.nextLine().trim().toUpperCase();
            
            //  Proteção contra entrada vazia
            char marcada = entrada.isEmpty() ? 'X' : entrada.charAt(0);

            Resposta r = new Resposta();
            r.setQuestaoId(q.getId());
            r.setAlternativaMarcada(marcada);
            r.setCorreta(q.isRespostaCorreta(marcada));
            
            //a lista de respostas foi inicializada na classe Tentativa
            tentativa.getRespostas().add(r);
            System.out.println(r.isCorreta() ? "Resposta correta!" : "Resposta incorreta.");
        }
        
        tentativas.add(tentativa);
        System.out.println("Prova finalizada com sucesso!");
    }

    public void listarTentativas() {
        if (tentativas.isEmpty()) {
            System.out.println("Nenhuma tentativa registrada.");
            return;
        }
        tentativas.forEach(t -> 
            System.out.println("Tentativa ID: " + t.getId() + " | Part. ID: " + t.getParticipanteId() + " | Prova ID: " + t.getProvaId())
        );
    }
}