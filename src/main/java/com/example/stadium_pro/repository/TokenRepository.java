package com.example.stadium_pro.repository;


import com.example.stadium_pro.model.entity.Admin;
import com.example.stadium_pro.model.entity.Client;
import com.example.stadium_pro.model.security.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TokenRepository extends JpaRepository<Token, Integer> {


    @Query("""
    select t from Token t inner join Client c on t.client.clientId = c.clientId
    where t.client.clientId = :clientId and t.loggedOut = false
    """)
    List<Token> findAllTokensByClient(Long clientId);

    @Query("""
    select t from Token t inner join Admin a on t.admin.adminId = a.adminId
    where t.admin.adminId = :adminId and t.loggedOut = false
    """)
    List<Token> findAllTokensByAdmin(Long adminId);
    Optional<Token> findByToken(String token);
    Token findByClientAndLoggedOutIsFalse(Client client);
    Token findByAdminAndLoggedOutIsFalse(Admin admin);

}