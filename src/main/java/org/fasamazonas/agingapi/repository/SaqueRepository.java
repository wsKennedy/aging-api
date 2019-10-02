package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.dto.SaqueDTO;
import org.fasamazonas.agingapi.model.Saque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by wsLima on 2019-08
 */
public interface SaqueRepository extends JpaRepository<Saque, Long> {

    @Query("SELECT  new org.fasamazonas.agingapi.model.dto.SaqueDTO( b.protocolo, b.nome, s.valor, s.dataSaque, s.descricao ) "
            + " from Beneficiario as b "
            + " inner join  Saque as s ON  b.id = s.beneficiario.id "
            + " where s.dataSaque between ?1 and ?2 order by s.protocolo")
    List<SaqueDTO> findAllSaques(LocalDate dtInital, LocalDate dtFinal);

    @Query(value = " select distinct s.protocolo from financa.saque as s "
            + " inner join (select  max(data_saque) as data from financa.saque "
            + " where data_saque between ?1 and ?2 group by protocolo) sq on s.data_saque = sq.data", nativeQuery = true)
    List<Long> findByLast(LocalDate dtInitial, LocalDate dtFinal);

    @Query("SELECT  new org.fasamazonas.agingapi.model.dto.SaqueDTO( b.protocolo, b.nome, s.valor, s.dataSaque, s.descricao ) "
            + " from Beneficiario as b "
            + " inner join  Saque as s ON  b.id = s.beneficiario.id "
            + " where s.protocolo = ?1")
    List<SaqueDTO> findByProtocolo(Long protocolo);


}

