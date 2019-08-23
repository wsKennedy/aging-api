package org.fasamazonas.agingapi.model.DTO;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class BeneficiarioDTO {

    private Long protocolo;

    private String nome;

    private BigDecimal valorPagamento;

    private LocalDate dataPagamento;

    private BigDecimal valorSaque;

    private LocalDate dataSaque;

    public BeneficiarioDTO(){}

    public  BeneficiarioDTO(Long protocolo, String nome, BigDecimal valorPagamento, LocalDate dataPagamento, BigDecimal valorSaque, LocalDate dataSaque){

        this.protocolo = protocolo;
        this.nome = nome;
        this.valorPagamento = valorPagamento;
        this.dataPagamento = dataPagamento;
        this.valorSaque = valorSaque;
        this.dataSaque = dataSaque;


    }
}
