package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.DTO.PagamentoDTO;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.fasamazonas.agingapi.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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


    @GetMapping()
    public Page<PagamentoDTO> findAllPagamentos(
            @RequestParam( value = "page", required = false, defaultValue = "0") int page,
            @RequestParam( value = "size", required = false, defaultValue = "30") int size,
            @PathVariable LocalDate dateInitial,@PathVariable LocalDate dateFinal) {
        return pagamentoService.findAllPagamentos( page, size, dateInitial, dateFinal);

    }

    @GetMapping("/{protocolo}")
    public List<PagamentoDTO> findByProtocolo(@PathVariable Long protocolo ) {
        return pagamentoService.findByProtocolo( protocolo);

    }

}
