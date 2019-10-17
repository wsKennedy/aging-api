package org.fasamazonas.agingapi.service;

import org.fasamazonas.agingapi.model.Parametro;
import org.fasamazonas.agingapi.model.dto.BeneficiarioDTO;
import org.fasamazonas.agingapi.repository.BeneficiarioRepository;
import org.fasamazonas.agingapi.repository.PagamentoRepository;
import org.fasamazonas.agingapi.repository.ParametroRepository;
import org.fasamazonas.agingapi.repository.SaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    private static final String DATA_BASE = "data_base";

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @Autowired
    private SaqueRepository saqueRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ParametroRepository parametroRepository;


    private final int PROTOCOLO =         0;
    private final int NOME =              1;
    private final int DATA_PAGAMENTO =    2;
    private final int DATA_SAQUE =        3;


    public List<BeneficiarioDTO> findAllBeneficiarios(){

        List<Object[]> queryResult = beneficiarioRepository.findAllBeneficiarios().stream().distinct().collect(Collectors.toList());

        Parametro param = parametroRepository.findParametro(DATA_BASE);

        return queryResult.stream().map(item -> {
            BeneficiarioDTO dto = new BeneficiarioDTO();

            dto.setNome(((String) item[NOME]));
            dto.setProtocolo(((BigInteger) item[PROTOCOLO]).longValue());
            dto.setValorPagamento(pagamentoRepository.valorPagamento(dto.getProtocolo()));
            dto.setValorSaque(saqueRepository.valorSaque(dto.getProtocolo()));
            dto.setDataPagamento(LocalDate.parse(item[DATA_PAGAMENTO].toString()));
            dto.setDataSaque(LocalDate.parse(item[DATA_SAQUE].toString()));
            dto.setSaldo(dto.getValorPagamento().subtract(dto.getValorSaque()));
            dto.setDataBase(LocalDate.parse(param.getValor()));

            Integer meses = getIntervalDate(dto.getDataPagamento(), dto.getDataBase());

            dto.setMeses(meses);

            return dto;

        }).collect(Collectors.toList());

    }

    public Integer getIntervalDate(LocalDate dtInitial, LocalDate dtFinal ) {
        Period period = Period.between(dtInitial,dtFinal);
        return period.getMonths();
    }


}
