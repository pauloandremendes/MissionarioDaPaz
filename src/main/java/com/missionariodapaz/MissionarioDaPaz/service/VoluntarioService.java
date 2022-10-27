package com.missionariodapaz.MissionarioDaPaz.service;

import com.missionariodapaz.MissionarioDaPaz.model.domain.Voluntario;
import com.missionariodapaz.MissionarioDaPaz.repository.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class VoluntarioService implements Serializable {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public Voluntario create(final Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    public List<Voluntario> findCenters() {
        List<Voluntario> voluntarios = voluntarioRepository.findAll();
        return voluntarios;
    }

    public Voluntario update(final Voluntario voluntario) {
        return voluntarioRepository.save(voluntario);
    }

    //Colocar uma validação...Se tiver um novos membros, não deve excluir o cev
    public void delete(final Long id) {
        voluntarioRepository.deleteById(id);
    }
}
