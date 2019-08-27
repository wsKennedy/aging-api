package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.Beneficiario;
import org.fasamazonas.agingapi.model.DTO.BeneficiarioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by wsLima
 */
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {


    @Query(" select  new org.fasamazonas.agingapi.model.DTO.BeneficiarioDTO( b.protocolo, b.nome, p.valor, s.valor, (p.valor - s.valor), s.dataSaque )"
            + " from Beneficiario as b "
            + " inner join  Pagamento as p ON  b.id = p.beneficiario.id "
            + " inner join  Saque as s ON b.id = s.beneficiario.id ORDER BY b.protocolo")
    public Page<BeneficiarioDTO> findAllBeneficiarios( Pageable pageable );


}

