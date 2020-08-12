package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.OperacaoDTO;
import br.com.rd.pi.pdv.repository.OperacaoRepository;
import br.com.rd.pi.pdv.service.bo.OperacaoBO;
import org.springframework.beans.factory.annotation.Autowired;

public class OperacaoService {

    @Autowired
    private OperacaoRepository repository;

    @Autowired
    private OperacaoBO operacaoBO;

    public OperacaoDTO buscarOperacao(Long codigo){
        return operacaoBO.parseToDTO(repository.getOne(codigo));
    }
}
