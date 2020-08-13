package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.model.entity.RecargaEntity;
import br.com.rd.pi.pdv.repository.RecargaRepository;
import br.com.rd.pi.pdv.service.bo.RecargaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecargaService {

    @Autowired
    private RecargaRepository repository;

    @Autowired
    private RecargaBO bo;

    public List<RecargaDTO> buscarTodas(){
        List<RecargaEntity> listEntity = repository.findAll();
        List<RecargaDTO> listDTO = new ArrayList<>();

        for(RecargaEntity entity : listEntity){
            RecargaDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

    public void inserir (RecargaDTO dto){
        RecargaEntity entity = bo.parseToEntity(dto, null);
        if(entity.getIdRecarga() != null)
            repository.save(entity);
    }

}