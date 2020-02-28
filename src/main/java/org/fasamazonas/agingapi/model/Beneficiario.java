package org.fasamazonas.agingapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "beneficiario", schema = "financa")
public class Beneficiario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "id_beneficiario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="beneficiario_sequence")
    @SequenceGenerator(name = "beneficiario_sequence", sequenceName = "financa.beneficiario_id_beneficiario_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private String protocolo;

    @NotNull
    private String nome;

}
