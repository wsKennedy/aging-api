package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.DTO.SaqueDTO;
import org.fasamazonas.agingapi.model.Pagamento;
import org.fasamazonas.agingapi.model.Saque;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.fasamazonas.agingapi.service.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/saques")
public class SaqueResource {

    @Autowired
    private SaqueRepository saqueRepository;

    @Autowired
    private SaqueService saqueService;

    @GetMapping()
    public Page<SaqueDTO> findAllBeneficiarios(
            @RequestParam( value = "page", required = false, defaultValue = "0") int page,
            @RequestParam( value = "size", required = false, defaultValue = "30") int size,
            @RequestParam LocalDate dateInitial,
            @RequestParam LocalDate dateFinal){

        return saqueService.findAllSaques( page, size, dateInitial, dateFinal);

    }



}
