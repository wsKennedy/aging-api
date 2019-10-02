package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.dto.PagamentoDTO;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoDTO> findAllPagamentos( LocalDate dtInitial, LocalDate dtFinal ) {
        return pagamentoRepository.findAllPagamentos( dtInitial, dtFinal );
    }

    public List<PagamentoDTO> findByProtocolo( Long protocolo ) {
        return pagamentoRepository.findByProtocolo( protocolo );
    }

    public List<Long> findByLast(LocalDate dtInitial, LocalDate dtFinal) {
        return pagamentoRepository.findByLast( dtInitial, dtFinal );
    }
}
