package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.dto.PagamentoDTO;
import org.fasamazonas.agingapi.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by wsLima
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query(" select new org.fasamazonas.agingapi.model.dto.PagamentoDTO( b.protocolo, b.nome, p.valor, p.dataPagamento ) "
            + "from Beneficiario as b "
            + "inner join  Pagamento as p ON  b.id = p.beneficiario.id "
            + "where p.dataPagamento between ?1 and ?2 order by p.protocolo")
    List<PagamentoDTO> findAllPagamentos(LocalDate dateInitial, LocalDate dateFinal);

    @Query(value = " select distinct p.protocolo from financa.pagamento as p "
            + " inner join (select  max(data_pagamento) as data from financa.pagamento "
            + " where data_pagamento between ?1 and ?2 group by protocolo) pg on p.data_pagamento = pg.data", nativeQuery = true)
    List<Long> findByLast(LocalDate dtInitial, LocalDate dtFinal);


    @Query(" select new org.fasamazonas.agingapi.model.dto.PagamentoDTO( b.protocolo, b.nome, p.valor, p.dataPagamento ) "
            + "from Beneficiario as b "
            + "inner join  Pagamento as p ON  b.id = p.beneficiario.id "
            + "where p.protocolo = ?1 "  )
    List<PagamentoDTO> findByProtocolo(Long protocolo);


}

