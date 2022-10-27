package com.missionariodapaz.MissionarioDaPaz.repository;

import com.missionariodapaz.MissionarioDaPaz.model.domain.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
}
