package com.example.touk.Service;

import com.example.touk.model.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);
    List<Client> getAllClients();
    Client getClientByID(Long id);
    Client updateClient(Client client, Long id);
    void deleteClient(Long id);
}
