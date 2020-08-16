package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.ClienteDTO;
import br.com.rd.pi.pdv.model.dto.PagamentoDocDTO;
import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.model.entity.ClienteEntity;
import br.com.rd.pi.pdv.model.entity.PagamentoDocEntity;
import br.com.rd.pi.pdv.model.entity.RecargaEntity;
import br.com.rd.pi.pdv.repository.ClienteRepository;
import br.com.rd.pi.pdv.service.bo.ClienteBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteBO clienteBO;

    public ClienteDTO buscarClienteId(Long codigo){
        return clienteBO.parseToDTO(repository.getOne(codigo));
    }

    public List<ClienteDTO> buscarTodosCliente(){
        List<ClienteEntity> listEntity = repository.findAll();
        List<ClienteDTO> listDTO = new ArrayList<>();

        for(ClienteEntity entity : listEntity){
            ClienteDTO dto = clienteBO.parseToDTO(entity);
            listDTO.add(dto);
        }
        return listDTO;
    }

    public void inserir (ClienteDTO dto){
        ClienteEntity entity = clienteBO.parseToEntity(dto,null);
        if(entity.getIdCliente() != null)
            repository.save(entity);
    }


}
