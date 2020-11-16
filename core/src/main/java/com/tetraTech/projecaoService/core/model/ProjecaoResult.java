package com.tetraTech.projecaoService.core.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@ToString
public class ProjecaoResult implements Serializable {


    private String dataHoraChamada;
    private String dataHoraProjecao;
    private String populacaoEstimadaAtual;
    private String populacaoEstimadaFutura;


    public ProjecaoResult( String dataHoraChamada, String populacaoEstimadaAtual, String dataHora, String populacaoEstimada) {

        this.dataHoraChamada = dataHoraChamada;
        this.populacaoEstimadaAtual = populacaoEstimadaAtual;
        this.dataHoraProjecao = dataHora;
        this.populacaoEstimadaFutura = populacaoEstimada;
    }



    public String objectToJson (ProjecaoResult projecao) throws JsonProcessingException {

        ObjectMapper Obj = new ObjectMapper();
        String jsonObject = Obj.writeValueAsString(projecao);
        return jsonObject;
    }
}
