package org.fasamazonas.agingapi.model.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class BeneficiarioDTO {

    private String protocolo;

    private String nome;

    private BigDecimal valorPagamento;

    private BigDecimal saldo;

    private LocalDate dataPagamento;

    private BigDecimal valorSaque;

    private LocalDate dataSaque;

    private LocalDate dataBase;

    private int meses;

}
