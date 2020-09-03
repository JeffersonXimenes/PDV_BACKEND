package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.LmpmItemDTO;
import br.com.rd.pi.pdv.model.entity.LmpmItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LmpmItemBO {

    @Autowired
    private LmpmBO lmpmBO;

    @Autowired
    private ProdutoBO produtoBO;

    public LmpmItemDTO parseToDTO(LmpmItemEntity entity){
        LmpmItemDTO dto = new LmpmItemDTO();
        dto.setIdLmpmItem(entity.getIdLmpmItem());
        dto.setPcDesconto(entity.getPcDesconto());
        dto.setQtdProduto(entity.getQtdProduto());
        dto.setLmpm(lmpmBO.parseToDto(entity.getLmpm()));
        dto.setProduto(produtoBO.parseToDTO(entity.getProduto()));

        return dto;
    }


}
