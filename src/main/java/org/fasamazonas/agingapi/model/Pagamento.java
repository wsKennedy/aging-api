package org.fasamazonas.agingapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pagamento", schema = "financa")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_pagamento")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pagamento_sequence")
    @SequenceGenerator(name = "pagamento_sequence", sequenceName = "financa.pagamento_id_pagamento_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private String protocolo;

    @NotNull
    private BigDecimal valor;

    @NotNull
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_beneficiario")
    private Beneficiario beneficiario;
}
