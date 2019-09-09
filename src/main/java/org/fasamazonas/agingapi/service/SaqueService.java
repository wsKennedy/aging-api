package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.DTO.SaqueDTO;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaqueService {

    @Autowired
    private SaqueRepository saqueRepository;

    public Page<SaqueDTO> findAllSaques(int page , int size, LocalDate dateInital, LocalDate dateFinal){
        PageRequest pageRequest = PageRequest.of( page, size, Sort.Direction.ASC, "nome");
        return saqueRepository.findAllSaques(pageRequest, dateInital, dateFinal);
    }

}
