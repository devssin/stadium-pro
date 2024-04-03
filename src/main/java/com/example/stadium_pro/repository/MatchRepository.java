package com.example.stadium_pro.repository;

import com.example.stadium_pro.model.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
