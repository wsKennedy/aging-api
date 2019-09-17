package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.DTO.PagamentoDTO;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Page<PagamentoDTO> findAllPagamentos(int page, int size, LocalDate dateInitial, LocalDate dateFinal){
        PageRequest pageRequest = PageRequest.of( page, size, Sort.Direction.ASC, "nome");
        return pagamentoRepository.findAllPagamentos(pageRequest, dateInitial, dateFinal);
    }

    public List<PagamentoDTO> findByProtocolo(Long protocolo){
        return pagamentoRepository.findByProtocolo(protocolo);
    }
}
