package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.DTO.BeneficiarioDTO;
import org.fasamazonas.agingapi.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Page<BeneficiarioDTO> findAllBeneficiarios(int page, int size){
        PageRequest pageRequest = PageRequest.of( page, size, Sort.Direction.ASC, "nome");
        return beneficiarioRepository.findAllBeneficiarios(pageRequest);
    }
}
