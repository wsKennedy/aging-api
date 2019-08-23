package org.fasamazonas.agingapi.repository;

import org.fasamazonas.agingapi.model.Beneficiario;
import org.fasamazonas.agingapi.model.Paramentro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wsLima on 2019-08
 */
public interface ParametroRepository extends JpaRepository<Paramentro, Long> {

    @Query(value = "SELECT p.* FROM config.parametro p WHERE nome = ?1 ",
            nativeQuery = true)
    List<Paramentro> findParamentroByKey(String key);


}

