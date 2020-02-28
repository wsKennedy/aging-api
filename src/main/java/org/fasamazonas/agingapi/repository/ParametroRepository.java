package org.fasamazonas.agingapi.repository;


import org.fasamazonas.agingapi.model.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * Created by wsLima on 2019-08
 */
public interface ParametroRepository extends JpaRepository<Parametro, Long> {


    Parametro findByNome(String nome);


}

