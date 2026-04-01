package br.com.ucsal.olimpiadas;

public class Resposta {

    // MUDANÇA: Usar Long (Objeto) para manter o padrão das outras classes de ID
    private Long questaoId;
    private char alternativaMarcada;
    private boolean correta;

    public Long getQuestaoId() {
        return questaoId;
    }

    public void setQuestaoId(Long questaoId) {
        this.questaoId = questaoId;
    }

    public char getAlternativaMarcada() {
        return alternativaMarcada;
    }

    public void setAlternativaMarcada(char alternativaMarcada) {
        // Garantimos que a alternativa seja salva sempre em maiúsculo
        this.alternativaMarcada = Character.toUpperCase(alternativaMarcada);
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}