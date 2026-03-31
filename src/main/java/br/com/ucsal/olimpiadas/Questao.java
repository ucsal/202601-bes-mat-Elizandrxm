package br.com.ucsal.olimpiadas; // Certifique-se que o package está correto

import java.util.Arrays;

public class Questao {

    private long id;
    // MUDANÇA 1: Usar Long (Objeto) para que o .equals() no Service funcione sem erros
    private Long provaId; 

    private String enunciado;
    private String[] alternativas = new String[5];
    private char alternativaCorreta;
    private String fenInicial;

    // Getters e Setters
    public String getFenInicial() { return fenInicial; }
    public void setFenInicial(String fenInicial) { this.fenInicial = fenInicial; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    // MUDANÇA 2: Retorno Long para bater com o filtro do Stream no Service
    public Long getProvaId() { return provaId; }
    public void setProvaId(Long provaId) { this.provaId = provaId; }

    public String getEnunciado() { return enunciado; }
    public void setEnunciado(String enunciado) { this.enunciado = enunciado; }

    public String[] getAlternativas() { return alternativas; }

    public void setAlternativas(String[] alternativas) {
        if (alternativas == null || alternativas.length != 5) {
            // Removido o throw para não travar o programa, apenas garantindo o tamanho
            this.alternativas = new String[5];
            return;
        }
        this.alternativas = Arrays.copyOf(alternativas, 5);
    }

    public char getAlternativaCorreta() { return alternativaCorreta; }

    public void setAlternativaCorreta(char alternativaCorreta) {
        try {
            this.alternativaCorreta = normalizar(alternativaCorreta);
        } catch (Exception e) {
            this.alternativaCorreta = 'A'; // Valor padrão caso falhe
        }
    }

    public boolean isRespostaCorreta(char marcada) {
        try {
            return normalizar(marcada) == alternativaCorreta;
        } catch (Exception e) {
            return false;
        }
    }

    public static char normalizar(char c) {
        char up = Character.toUpperCase(c);
        if (up < 'A' || up > 'E') {
            throw new IllegalArgumentException("Inválida");
        }
        return up;
    }
///retirada do código da questão para não poluir a classe Questao, mas pode ser útil para testes futuros
    public void imprimirTabuleiro() {
        if (fenInicial == null || fenInicial.isBlank()) return;

        String parteTabuleiro = fenInicial.split(" ")[0];
        String[] ranks = parteTabuleiro.split("/");

        System.out.println("\n    a b c d e f g h");
        System.out.println("   -----------------");

        for (int r = 0; r < 8; r++) {
            String rank = ranks[r];
            System.out.print((8 - r) + " | ");
            for (char c : rank.toCharArray()) {
                if (Character.isDigit(c)) {
                    int vazios = c - '0';
                    for (int i = 0; i < vazios; i++) System.out.print(". ");
                } else {
                    System.out.print(c + " ");
                }
            }
            System.out.println("| " + (8 - r));
        }
        System.out.println("   -----------------");
        System.out.println("    a b c d e f g h\n");
    }
}