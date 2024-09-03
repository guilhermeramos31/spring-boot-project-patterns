package com.example.projectpatterns.repository.interfaces;

import com.example.projectpatterns.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientRepository {
    void delete(UUID id);
    List<Client> findAll();
    Client save(Client client);
    Client findById(UUID id);
}
