package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.PagamentoDocDTO;
import br.com.rd.pi.pdv.model.entity.PagamentoDocEntity;
import br.com.rd.pi.pdv.repository.PagamentoDocRepository;
import br.com.rd.pi.pdv.service.bo.PagamentoDocBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoDocService {

    @Autowired
    private PagamentoDocRepository repository;

    @Autowired
    private PagamentoDocBO pagamentoDocBO;

    public List<PagamentoDocDTO> buscarTodosPagamentos() {
        List<PagamentoDocEntity> listEntity = repository.findAll();
        List<PagamentoDocDTO> listDTO = new ArrayList<>();

        for (PagamentoDocEntity entity : listEntity) {
            PagamentoDocDTO dto = pagamentoDocBO.parseToDTO(entity);
            listDTO.add(dto);
        }
        return listDTO;
    }

}