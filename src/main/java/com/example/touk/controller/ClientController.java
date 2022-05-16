package com.example.touk.controller;

import com.example.touk.Service.ClientService;
import com.example.touk.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return new ResponseEntity<Client>(clientService.saveClient(client), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") long clientId){
        return new ResponseEntity<Client>(clientService.getClientByID(clientId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client){
        return new ResponseEntity<Client>(clientService.updateClient(client, id), HttpStatus.OK);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteClient(@PathVariable("id") long id){
        clientService.deleteClient(id);
        return new ResponseEntity<String>("Client :"+ id + " deleted succesfully!", HttpStatus.OK);
    }
}
