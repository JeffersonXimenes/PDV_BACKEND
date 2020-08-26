package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.FilialDTO;
import br.com.rd.pi.pdv.repository.FilialRepository;
import br.com.rd.pi.pdv.service.bo.FilialBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilialService {

    @Autowired
    private FilialRepository repository;
    @Autowired
    private FilialBO filialBo;

    public FilialDTO BuscarFilial(Long codigo){
        return filialBo.parseToDTO(repository.getOne(codigo));

    }

}
