package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.Pagamento;
import org.fasamazonas.agingapi.model.Saque;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wsLima on 2019-08
 */
public interface SaqueRepository extends JpaRepository<Saque, Long> {

    //Page<Payment> filter(final Pageable pageable);

}

