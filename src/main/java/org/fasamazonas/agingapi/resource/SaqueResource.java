package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.dto.SaqueDTO;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.fasamazonas.agingapi.service.SaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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


    //? TRAZ TODOS OS SAQUES DENTRO DE UM PERÍODO.
    @GetMapping
    public List<SaqueDTO> findAllSaques(
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd" ) LocalDate dtInitial,
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd" ) LocalDate dtFinal ) {

        return saqueService.findAllSaques( dtInitial, dtFinal );

    }

    //? TRAZ TODOS OS SAQUES DE UM BENEFICIÁRIO(PROTOCOLO).
    @GetMapping("/{protocolo}")
    public List<SaqueDTO> findByProtocolo( @PathVariable Long protocolo){
        return saqueService.findByProtocolo(protocolo);
    }

    //? TRAZ OS PROTOCOLOS DOS ULTIMOS PAGAMENTOS
    @GetMapping("/last")
    public List<Long> findByLast(
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate dtInitial,
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate dtFinal ) {
        return saqueService.findByLast( dtInitial, dtFinal );
    }




}
