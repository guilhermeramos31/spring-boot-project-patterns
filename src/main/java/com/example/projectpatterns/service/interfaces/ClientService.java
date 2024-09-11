package com.example.projectpatterns.service.interfaces;

import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientRequestUpdate;
import com.example.projectpatterns.model.dto.ClientResponse;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientResponse save(ClientRequest client);

    ClientResponse update(UUID id, ClientRequestUpdate clientRequest);

    ClientResponse findById(UUID id);

    String delete(UUID id);

    List<ClientResponse> findAll();
}
