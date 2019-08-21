package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.Beneficiario;
import org.fasamazonas.agingapi.model.Paramentro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wsLima
 */
public interface ParametroRepository extends JpaRepository<Paramentro, Long> {

    //Page<Payment> filter(final Pageable pageable);

}

