package com.example.stadium_pro.service.impl;

import com.example.stadium_pro.model.entity.Admin;
import com.example.stadium_pro.model.entity.Client;
import com.example.stadium_pro.repository.AdminRepository;
import com.example.stadium_pro.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;

    public UserDetailsServiceImp(AdminRepository adminRepository, ClientRepository clientRepository) {
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> adminOptional = adminRepository.findByUsername(username);
        if (adminOptional.isPresent()) {
            return adminOptional.get();
        }

        Optional<Client> clientOptional = clientRepository.findByUsername(username);
        if (clientOptional.isPresent()) {
            return clientOptional.get();
        }

        throw new UsernameNotFoundException("User not found");
    }

}
