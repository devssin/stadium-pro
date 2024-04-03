package com.example.stadium_pro.repository;

import com.example.stadium_pro.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
