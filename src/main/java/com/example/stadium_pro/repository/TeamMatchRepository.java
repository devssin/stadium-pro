package com.example.stadium_pro.repository;

import com.example.stadium_pro.model.entity.TeamMatch;
import com.example.stadium_pro.model.identity.TeamMatchId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamMatchRepository extends JpaRepository<TeamMatch, Long> {

    Optional<TeamMatch> findById(TeamMatchId teamMatchIdDTO);
}
