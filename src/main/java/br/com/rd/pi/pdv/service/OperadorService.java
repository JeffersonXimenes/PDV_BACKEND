package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.OperadorDTO;
import br.com.rd.pi.pdv.repository.OperadorRepository;
import br.com.rd.pi.pdv.service.bo.OperadorBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository repository;

    @Autowired
    private OperadorBO operadorBO;

    public OperadorDTO buscarOperadorId(Long codigo){
        return operadorBO.parseToDTO(repository.getOne(codigo));
    }
}
