package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.model.entity.RecargaEntity;
import br.com.rd.pi.pdv.repository.OperadoraRepository;
import br.com.rd.pi.pdv.repository.RecargaRepository;
import br.com.rd.pi.pdv.service.bo.RecargaBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecargaService {

    @Autowired
    private RecargaRepository recargaRepository;

    @Autowired
    private RecargaBO bo;

    @Autowired
    private OperadoraRepository operadoraRepository;

    @PersistenceContext
    private EntityManager em;

//    public List<RecargaDTO> buscarTodas(){
//        List<RecargaEntity> listEntity = recargaRepository.findAll();
//        List<RecargaDTO> listDTO = new ArrayList<>();
//
//        for(RecargaEntity recargas : listEntity){
//            RecargaDTO dto =  new RecargaDTO();
//
//            //dto.setIdOperadora(recargas.getOperadoraID().getIdOperadora());
//            dto.setIdRecarga(recargas.getIdRecarga());
//            dto.setIdOperadora(recargas.getOperadoraID().getIdOperadora());
//            //listDTO.add(dto);
//            //dto.setIdOperadora(entity.getOperadoraID().getIdOperadora());
//            List<OperadoraDTO> itens = new ArrayList<>();
//
//            for(OperadoraEntity item : recargas.getItensRecargas()){
//                OperadoraDTO itDTO = new OperadoraDTO();
//
//                itDTO.setIdOperadora(item.getIdOperadora());
//                itDTO.setDescricaoOperadora(item.getDescricaoOperadora());
//
//                itens.add(itDTO);
//            }
//
//            dto.setItems(itens);
//            listDTO.add(dto);
//
//        }
//
//
//        return listDTO;
//    }

    public List<RecargaDTO> buscarTodas(){
        List<RecargaEntity> listEntity = recargaRepository.findAll();
        List<RecargaDTO> listDTO = new ArrayList<>();

        for(RecargaEntity entity : listEntity){
            RecargaDTO dto = bo.parseToDTO(entity);
            listDTO.add(dto);
        }

        return listDTO;
    }

//    public List<RecargaEntity> buscarDsOperadora(Long idOperadora) {
//        return em.createNamedQuery("buscarDsOperadora", RecargaEntity.class).setParameter("idOperadora", idOperadora).getResultList();
//    }

    public List<RecargaEntity> buscarPorIdOperadora(Long idOperadora) {
        return recargaRepository.findByOperadora(operadoraRepository.getOne(idOperadora));
    }


    public void inserir (RecargaDTO dto){
        RecargaEntity entity = bo.parseToEntity(dto, null);
        if(entity.getIdRecarga() != null)
            recargaRepository.save(entity);
    }

}