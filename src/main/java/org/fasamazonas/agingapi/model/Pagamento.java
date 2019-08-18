package org.fasamazonas.agingapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal protocolo;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate data;
}
