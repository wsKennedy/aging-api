package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.DTO.SaqueDTO;
import org.fasamazonas.agingapi.model.Pagamento;
import org.fasamazonas.agingapi.model.Saque;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.fasamazonas.agingapi.service.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/saques")
public class SaqueResource {

    @Autowired
    private SaqueRepository saqueRepository;

    @Autowired
    private SaqueService saqueService;

    @GetMapping("/{dateInitial}/{dateFinal}")
    public Page<SaqueDTO> findAllBeneficiarios(
            @RequestParam( value = "page", required = false, defaultValue = "0") int page,
            @RequestParam( value = "size", required = false, defaultValue = "30") int size,
            @PathVariable LocalDate dateInitial,
            @PathVariable LocalDate dateFinal){

        return saqueService.findAllSaques( page, size, dateInitial, dateFinal);

    }

    @GetMapping("/{protocolo}")
    public List<SaqueDTO> findByProtocolo( @PathVariable Long protocolo){
        return saqueService.findByProtocolo(protocolo);
    }




}
