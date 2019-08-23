package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.DTO.BeneficiarioDTO;
import org.fasamazonas.agingapi.repository.BeneficiarioRepository;
import org.fasamazonas.agingapi.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioResource {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private BeneficiarioService beneficiarioSevice;

    @GetMapping()
    public Page<BeneficiarioDTO> findAllBeneficiarios(
            @RequestParam( value = "page", required = false, defaultValue = "0") int page,
            @RequestParam( value = "size", required = false, defaultValue = "10") int size) {
        return beneficiarioSevice.findAllBeneficiarios( page, size);

    }

}
