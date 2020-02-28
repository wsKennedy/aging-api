package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.Parametro;
import org.fasamazonas.agingapi.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParametroService {

    private static final String DATA_BASE = "data_base";

    @Autowired
    private ParametroRepository parametroRepository;

    public Parametro findParametro( ) {
        return parametroRepository.findByNome(DATA_BASE);
    }

}
