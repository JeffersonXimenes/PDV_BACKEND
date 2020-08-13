package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.ClienteDTO;
import br.com.rd.pi.pdv.model.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteBO {

    public ClienteDTO parseToDTO(ClienteEntity entity){
        ClienteDTO dto = new ClienteDTO();

        if(entity == null)
            return dto;

        dto.setIdCliente(entity.getIdCliente());
        dto.setNumeroCpf(entity.getNumeroCpf());

        return dto;
    }

    public ClienteEntity parseToEntity(ClienteDTO dto, ClienteEntity entity){
        if (entity == null)
            entity = new ClienteEntity();

        if (dto == null)
            return entity;

        entity.setIdCliente(dto.getIdCliente());
        entity.setNumeroCpf(dto.getNumeroCpf());

        return entity;
    }

}
