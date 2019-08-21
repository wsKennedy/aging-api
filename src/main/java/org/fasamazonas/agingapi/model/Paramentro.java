package org.fasamazonas.agingapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "parametro", schema = "config")
public class Paramentro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "id_parametro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="parametro_sequence")
    @SequenceGenerator(name = "parametro_sequence", sequenceName = "config.parametro_id_parametro_seq", allocationSize = 1)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String valor;

    private String descricao;

}
