package org.fasamazonas.agingapi.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SaqueDTO {

    private Long protocolo;

    private String nome;

    private BigDecimal valorSaque;

    private LocalDate dataSaque;

    private String descricao;

    public SaqueDTO(){}

    public SaqueDTO(Long protocolo, String nome, BigDecimal valorSaque, LocalDate dataSaque, String descricao){

        this.protocolo = protocolo;
        this.nome = nome;
        this.valorSaque = valorSaque;
        this.dataSaque = dataSaque;
        this.descricao = descricao;

    }

}
