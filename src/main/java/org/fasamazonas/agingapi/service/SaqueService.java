package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.dto.SaqueDTO;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaqueService {

    @Autowired
    private SaqueRepository saqueRepository;

    public List<SaqueDTO> findAllSaques( LocalDate dtInital, LocalDate dtFinal ) {
        return saqueRepository.findAllSaques( dtInital, dtFinal );
    }

    public List<SaqueDTO> findByProtocolo(Long protocolo){
        return saqueRepository.findByProtocolo(protocolo);
    }

    public List<Long> findByLast(LocalDate dtInitial, LocalDate dtFinal) {
        return saqueRepository.findByLast( dtInitial, dtFinal );
    }

}
