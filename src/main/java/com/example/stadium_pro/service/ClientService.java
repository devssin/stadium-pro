// ClientService.java
package com.example.stadium_pro.service;

import com.example.stadium_pro.model.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getAllClients();
    ClientDTO getClientById(Long clientId);
    ClientDTO updateClient(Long clientId, ClientDTO clientDTO);
    void deleteClient(Long clientId);

}
