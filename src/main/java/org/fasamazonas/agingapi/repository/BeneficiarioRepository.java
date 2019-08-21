package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wsLima
 */
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    //Page<Payment> filter(final Pageable pageable);

}

