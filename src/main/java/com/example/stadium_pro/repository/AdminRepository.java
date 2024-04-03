package com.example.stadium_pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.stadium_pro.model.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}
