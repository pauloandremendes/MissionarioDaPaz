package com.missionariodapaz.MissionarioDaPaz.service;

import com.missionariodapaz.MissionarioDaPaz.model.domain.CentroEvangelizacao;
import com.missionariodapaz.MissionarioDaPaz.repository.CentroEvangelizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroEvangelizacaoService {

    @Autowired
    private CentroEvangelizacaoRepository centroEvangelizacaoRepository;

    public CentroEvangelizacao create(final CentroEvangelizacao centroEvangelizacao) {
        return centroEvangelizacaoRepository.save(centroEvangelizacao);
    }


    public List<CentroEvangelizacao> findCenters() {
        List<CentroEvangelizacao> centros = centroEvangelizacaoRepository.findAll();
        return centros;
    }

    public CentroEvangelizacao update(final CentroEvangelizacao centroEvangelizacao) {
        return centroEvangelizacaoRepository.save(centroEvangelizacao);
    }

    //Colocar uma validação...Se tiver um novos membros, não deve excluir o cev
    public void delete(final Long id) {
        centroEvangelizacaoRepository.deleteById(id);
    }
}
