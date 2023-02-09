package com.missionariodapaz.MissionarioDaPaz.repository;

import com.missionariodapaz.MissionarioDaPaz.model.domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

    Optional<UserModel> findByUsername(String username);


}
