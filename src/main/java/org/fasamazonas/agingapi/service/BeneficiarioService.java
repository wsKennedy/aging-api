package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.dto.BeneficiarioDTO;
import org.fasamazonas.agingapi.repository.BeneficiarioRepository;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private SaqueRepository saqueRepository;

    private final int PROTOCOLO =         0;
    private final int NOME =              1;
    private final int VALOR_PAGAMENTO =   2;
    private final int VALOR_SAQUE =       3;
    private final int SALDO =             4;
    private final int DATA_PAGAMENTO =    5;
    private final int DATA_SAQUE =        6;


    public List<BeneficiarioDTO> findAllBeneficiarios(LocalDate dtInitial, LocalDate dtFinal){

        List<Object[]> queryResult = beneficiarioRepository.findAllBeneficiarios(dtInitial, dtFinal).stream().distinct().collect(Collectors.toList());

        return queryResult.stream().map(item -> {
            BeneficiarioDTO dto = new BeneficiarioDTO();
            dto.setNome(((String) item[NOME]));
            dto.setProtocolo(((BigInteger) item[PROTOCOLO]).longValue());
            dto.setValorPagamento(((BigDecimal) item[VALOR_PAGAMENTO]));
            dto.setValorSaque(((BigDecimal) item[VALOR_SAQUE]));
            dto.setDataPagamento(LocalDate.parse(item[DATA_PAGAMENTO].toString()));
            dto.setDataSaque(LocalDate.parse(item[DATA_SAQUE].toString()));
            dto.setSaldo(((BigDecimal) item[SALDO]));

            return dto;

        }).collect(Collectors.toList());

    }


}
