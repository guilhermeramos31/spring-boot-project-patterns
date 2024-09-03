package com.example.projectpatterns.repository;

import com.example.projectpatterns.model.Address;
import com.example.projectpatterns.model.Client;
import com.example.projectpatterns.repository.interfaces.ClientRepository;
import com.example.projectpatterns.repository.interfaces.ClientRepositoryContext;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
    private final ClientRepositoryContext repository;

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client save(Client client) {
        return repository.save(client);
    }

    @Override
    public Client findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }
}
