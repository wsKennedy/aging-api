package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.DTO.SaqueDTO;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaqueService {

    @Autowired
    private SaqueRepository saqueRepository;

    public Page<SaqueDTO> findAllSaques(int page , int size){
        PageRequest pageRequest = PageRequest.of( page, size, Sort.Direction.ASC, "nome");
        return saqueRepository.findAllSaques(pageRequest);
    }

    public Page<SaqueDTO> search(int page , int size, String search){
        PageRequest pageRequest = PageRequest.of( page, size, Sort.Direction.ASC, "nome");
        return saqueRepository.search(pageRequest, search);
    }
}
