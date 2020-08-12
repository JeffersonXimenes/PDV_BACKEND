package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.ClienteDTO;
import br.com.rd.pi.pdv.model.entity.ClienteEntity;
import br.com.rd.pi.pdv.repository.ClienteRepository;
import br.com.rd.pi.pdv.service.bo.ClienteBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteBO clienteBO;

    public ClienteDTO buscarClienteId(Long codigo){
        return clienteBO.parseToDTO(repository.getOne(codigo));
    }

    public void inserir (ClienteDTO dto){
        ClienteEntity entity = clienteBO.parseToEntity(dto,null);
        if(entity.getIdCliente() != null)
            repository.save(entity);
    }


}
