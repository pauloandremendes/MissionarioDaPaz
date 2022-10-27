package com.missionariodapaz.MissionarioDaPaz.repository;

import com.missionariodapaz.MissionarioDaPaz.model.domain.CentroEvangelizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroEvangelizacaoRepository extends JpaRepository<CentroEvangelizacao, Long> {
}
