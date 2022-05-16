package com.example.touk.ServiceImpl;

import com.example.touk.Service.ClientService;
import com.example.touk.model.Client;
import com.example.touk.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientByID(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Client with id: " + id));
    }

    @Override
    public Client updateClient(Client client, Long id) {
        Client existingClient = clientRepository.findById(id).orElseThrow();
        existingClient.setName(client.getName());
        existingClient.setName(client.getSurname());
        clientRepository.save(existingClient);
        return existingClient;
    }

    @Override
    public void deleteClient(Long id) {
        Client deleteClient = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(deleteClient);
    }
}
