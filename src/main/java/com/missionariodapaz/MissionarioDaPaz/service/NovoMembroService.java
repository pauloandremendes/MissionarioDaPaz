package com.missionariodapaz.MissionarioDaPaz.service;

import com.missionariodapaz.MissionarioDaPaz.model.domain.NovoMembro;
import com.missionariodapaz.MissionarioDaPaz.model.domain.Voluntario;
import com.missionariodapaz.MissionarioDaPaz.repository.NovoMembroRepository;
import com.missionariodapaz.MissionarioDaPaz.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NovoMembroService {

    @Autowired
    private NovoMembroRepository novoMembroRepository;

    public NovoMembro create(final NovoMembro novoMembro) {
        return novoMembroRepository.save(novoMembro);
    }

    public List<NovoMembro> findCenters() {
        List<NovoMembro> novosMembros = novoMembroRepository.findAll();
        return novosMembros;
    }

    public NovoMembro update(final NovoMembro novoMembro) {
        return novoMembroRepository.save(novoMembro);
    }

    public void delete(final Long id) {
        novoMembroRepository.deleteById(id);
    }

}
