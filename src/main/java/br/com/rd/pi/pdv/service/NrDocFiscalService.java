package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.entity.NrDocFiscalEntity;
import br.com.rd.pi.pdv.repository.FilialRepository;
import br.com.rd.pi.pdv.repository.NrDocFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NrDocFiscalService {

    @Autowired
    private NrDocFiscalRepository nrDocFiscalRepository;

    @Autowired
    private FilialRepository filialRepository;

    public Long buscaNrProxNota (Long cdFilial){
        Long proxNumFiscal = nrDocFiscalRepository.getOne(cdFilial).getProxNumFiscal();
        atualizaNrProxNota(cdFilial);

        return proxNumFiscal;
    }

    private void atualizaNrProxNota (Long cdFilial){
        NrDocFiscalEntity nrDocFiscalEntity = nrDocFiscalRepository.getOne(cdFilial);
        nrDocFiscalEntity.setProxNumFiscal(nrDocFiscalEntity.getProxNumFiscal() + 1);

        nrDocFiscalRepository.save(nrDocFiscalEntity);
    }
}
