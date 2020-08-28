package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.OperadoraDTO;
import br.com.rd.pi.pdv.model.entity.OperadoraEntity;
import br.com.rd.pi.pdv.repository.OperadoraRepository;
import br.com.rd.pi.pdv.service.bo.OperadoraBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperadoraService {

    @Autowired
    private OperadoraBO operadoraBO;

    @Autowired
    private OperadoraRepository operadoraRepository;

    public List <OperadoraDTO> buscarOperadora (){
        List <OperadoraDTO> operadoraDTOS = new ArrayList<>();

        for (OperadoraEntity operadoraEntity:  operadoraRepository.findAll()) {
            OperadoraDTO operadoraDTO = operadoraBO.parseToDTO(operadoraEntity);
            operadoraDTOS.add(operadoraDTO);
        }
        return operadoraDTOS;
    }

    public OperadoraDTO buscarOperadoraId (Long idOperadora){
        return operadoraBO.parseToDTO(operadoraRepository.getOne(idOperadora));
    }
}
