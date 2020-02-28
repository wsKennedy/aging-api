package org.fasamazonas.agingapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "saque", schema = "financa")
public class Saque implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "id_saque")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="saque_sequence")
    @SequenceGenerator(name = "saque_sequence", sequenceName = "financa.saque_id_saque_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private String protocolo;

    @NotNull
    private BigDecimal valor;

    private String descricao;

    @NotNull
    @Column(name = "data_saque")
    private LocalDate dataSaque;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_beneficiario")
    private Beneficiario beneficiario;
}
