package org.fasamazonas.agingapi.model.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BeneficiarioDTO {

    private Long protocolo;

    private String nome;

    private BigDecimal valorPagamento;

    private BigDecimal saldo;

    private LocalDate dataPagamento;

    private BigDecimal valorSaque;

    private LocalDate dataSaque;

    public BeneficiarioDTO(){}

    public BeneficiarioDTO(Long protocolo, String nome, BigDecimal valorPagamento, BigDecimal valorSaque, BigDecimal saldo, LocalDate dataPagamento, LocalDate dataSaque) {
        this.protocolo = protocolo;
        this.nome = nome;
        this.valorPagamento = valorPagamento;
        this.dataPagamento = dataPagamento;
        this.valorSaque = valorSaque;
        this.saldo = saldo;
        this.dataSaque = dataSaque;
    }
}
