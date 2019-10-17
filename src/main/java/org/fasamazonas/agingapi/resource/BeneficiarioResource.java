package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.dto.BeneficiarioDTO;
import org.fasamazonas.agingapi.repository.BeneficiarioRepository;
import org.fasamazonas.agingapi.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioResource {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private BeneficiarioService beneficiarioSevice;

    @GetMapping
    public List<BeneficiarioDTO> findAllBeneficiarios() {
        return beneficiarioSevice.findAllBeneficiarios( );

    }

}
