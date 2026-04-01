package br.com.ucsal.olimpiadas; // Verifique se o package condiz com suas pastas

import java.util.ArrayList;
import java.util.List;

public class Tentativa {
    // MUDANÇA: Usar Long (Objeto) para IDs. 
    // Isso permite que o Service faça comparações seguras e use métodos como .equals()
    private Long id;
    private Long participanteId;
    private Long provaId;

    // MUDANÇA: Inicializar a lista de respostas aqui.
    // Assim garantimos que ela nunca será nula, evitando NullPointerException.
    private final List<Resposta> respostas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParticipanteId() {
        return participanteId;
    }

    public void setParticipanteId(Long participanteId) {
        this.participanteId = participanteId;
    }

    public Long getProvaId() {
        return provaId;
    }

    public void setProvaId(Long provaId) {
        this.provaId = provaId;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

  // MUDANÇA: Método para calcular a nota da tentativa.
    // Ele percorre as respostas e conta quantas estão corretas.
    public int calcularNota() {
        int acertos = 0;
        for (Resposta r : respostas) {
            if (r.isCorreta()) {
                acertos++;
            }
        }
        return acertos;
    }
}