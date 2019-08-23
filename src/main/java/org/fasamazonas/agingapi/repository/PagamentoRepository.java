package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.DTO.PagamentoDTO;
import org.fasamazonas.agingapi.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wsLima
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query(" select new org.fasamazonas.agingapi.model.DTO.PagamentoDTO( b.protocolo, b.nome, p.valor, p.dataPagamento ) "
            + "from Beneficiario as b "
            + "inner join  Pagamento as p ON  b.id = p.beneficiario.id ")
    public Page<PagamentoDTO> findAllPagamentos(Pageable pageable);


}

