package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.DTO.PagamentoDTO;
import org.fasamazonas.agingapi.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by wsLima
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    @Query(" select new org.fasamazonas.agingapi.model.DTO.PagamentoDTO( b.protocolo, b.nome, p.valor, p.dataPagamento ) "
            + "from Beneficiario as b "
            + "inner join  Pagamento as p ON  b.id = p.beneficiario.id "
            + "where p.dataPagamento between ?2 and ?3 order by p.protocolo")
    public Page<PagamentoDTO> findAllPagamentos(Pageable pageable, LocalDate dateInitial, LocalDate dateFinal);

    @Query(" select new org.fasamazonas.agingapi.model.DTO.PagamentoDTO( b.protocolo, b.nome, p.valor, p.dataPagamento ) "
            + "from Beneficiario as b "
            + "inner join  Pagamento as p ON  b.id = p.beneficiario.id "
            + "where p.protocolo = ?1 "  )
    public List<PagamentoDTO> findByProtocolo(Long protocolo);


}

