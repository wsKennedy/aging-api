package org.fasamazonas.agingapi.resource;

import org.fasamazonas.agingapi.model.Beneficiario;
import org.fasamazonas.agingapi.model.Paramentro;
import org.fasamazonas.agingapi.repository.BeneficiarioRepository;
import org.fasamazonas.agingapi.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parametros")
public class ParametroResource {

    private static final String DATA_BASE = "data_base";

    @Autowired
    private ParametroRepository parametroRepository;



    @GetMapping
    public List<Paramentro> findAll(){
        return parametroRepository.findParamentroByKey(DATA_BASE);
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
