package org.fasamazonas.agingapi.model.DTO;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
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
