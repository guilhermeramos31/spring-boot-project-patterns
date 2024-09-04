package com.example.projectpatterns.repository.interfaces;

import com.example.projectpatterns.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {
    void delete(UUID id);
    List<Client> findAll();
    Client findById(UUID id);
    Client save(Client client);
    Optional<Client> findByEmail(String email);
}
