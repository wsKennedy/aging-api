package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.DTO.SaqueDTO;
import org.fasamazonas.agingapi.model.Pagamento;
import org.fasamazonas.agingapi.model.Saque;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by wsLima on 2019-08
 */
public interface SaqueRepository extends JpaRepository<Saque, Long> {

    @Query("SELECT  new org.fasamazonas.agingapi.model.DTO.SaqueDTO( b.protocolo, b.nome, s.valor, s.dataSaque, s.descricao ) "
            + " from Beneficiario as b "
            + " inner join  Saque as s ON  b.id = s.beneficiario.id "
            + " where s.dataSaque between ?2 and ?3 order by s.protocolo")
    public Page<SaqueDTO> findAllSaques(Pageable pageable, LocalDate dateInital, LocalDate dateFinal);

}

