package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.Paramentro;
import org.fasamazonas.agingapi.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametroService {

    @Autowired
    private ParametroRepository parametroRepository;

    public List<Paramentro> findParametro(String tag){
        return parametroRepository.findParamentroByKey(tag);
    }

}
