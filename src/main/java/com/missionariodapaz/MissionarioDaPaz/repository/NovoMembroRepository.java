package com.missionariodapaz.MissionarioDaPaz.repository;

import com.missionariodapaz.MissionarioDaPaz.model.domain.NovoMembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovoMembroRepository extends JpaRepository<NovoMembro, Long> {
}
