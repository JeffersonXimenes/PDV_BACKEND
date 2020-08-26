package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.TipoPagamentoDTO;
import br.com.rd.pi.pdv.model.entity.TipoPagamentoEntity;
import br.com.rd.pi.pdv.repository.TipoPagamentoRepository;
import br.com.rd.pi.pdv.service.bo.TipoPagamentoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoPagamentoService {

    @Autowired
    private TipoPagamentoRepository repository;

    @Autowired
    private TipoPagamentoBO tipoPagamentoBO;

    public List<TipoPagamentoDTO> buscarTodosTipoPag() {
        List<TipoPagamentoEntity> listEntity = repository.findAll();
        List<TipoPagamentoDTO> listDTO = new ArrayList<>();

        for (TipoPagamentoEntity entity : listEntity) {
            TipoPagamentoDTO dto = tipoPagamentoBO.parseToDTO(entity);
            listDTO.add(dto);
        }
        return listDTO;
    }

}