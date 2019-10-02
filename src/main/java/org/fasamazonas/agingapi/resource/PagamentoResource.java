package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.dto.PagamentoDTO;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.fasamazonas.agingapi.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoResource {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoService pagamentoService;


    //? TRAZ TODOS OS PAGAMENTOS DENTRO DE UM PERÍODO.
    @GetMapping
    public List<PagamentoDTO> findAllPagamento(
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate dtInitial,
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate dtFinal
    ) {
        return pagamentoService.findAllPagamentos( dtInitial, dtFinal );

    }

    //? TRAZ TODOS OS PAGAMENTOS DE UM BENEFICIÁRIO(PROTOCOLO).
    @GetMapping("/{protocolo}")
    public List<PagamentoDTO> findByProtocolo( @PathVariable Long protocolo ) {
        return pagamentoService.findByProtocolo( protocolo );

    }

    //? TRAZ OS PROTOCOLOS DOS ULTIMOS PAGAMENTOS
    @GetMapping("/last")
    public List<Long> findByLast(
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate dtInitial,
            @RequestParam @DateTimeFormat( pattern = "yyyy-MM-dd") LocalDate dtFinal ) {
        return pagamentoService.findByLast( dtInitial, dtFinal );
    }

}
