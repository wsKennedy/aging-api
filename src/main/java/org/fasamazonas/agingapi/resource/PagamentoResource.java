package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.Pagamento;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoResource {

    @Autowired
    private PagamentoRepository pagamentoRepository;

//    @Autowired
//    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> findAll(){
        return pagamentoRepository.findAll();
    }

//    @GetMapping
//    public Page<Pagamento findAll(final Pageable pageable) {
//        return pagamentoRepository.filter(pageable);
//    }



//    @GetMapping("/{protocolo}")
//    public ResponseEntity<Pagamento> findByPro(@PathVariable final Long protocolo) {
//        final Optional<Pagamento> bean = pagamentoRepository.findById(protocolo);
//
//        return bean.isPresent() ? ResponseEntity.ok(bean.get()) : ResponseEntity.notFound().build();
//    }
}
