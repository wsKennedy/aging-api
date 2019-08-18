package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.Pagamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wsLima
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    Page<Pagamento> filter(final Pageable pageable);

}

