package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by wsLima
 */
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    @Query(value = " select  b.protocolo, b.nome, "
            + " (select  max(p.data_pagamento) as data from financa.pagamento p where p.protocolo = b.protocolo) as data_pagamento, "
            + " (select  max(s.data_saque) as data from financa.saque s where s.protocolo = b.protocolo) as data_saque,    "
            + " (select sum(p.valor) from financa.pagamento as p where p.protocolo = b.protocolo) as valor_pagamento, "
            + " (select sum(s.valor) from financa.saque as s where s.protocolo = b.protocolo) as valor_saque "
            + "  from financa.beneficiario as b  ", nativeQuery = true)
    List<Object[]> findAllBeneficiarios();


}

