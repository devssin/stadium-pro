package com.example.stadium_pro.repository;

import com.example.stadium_pro.model.entity.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
