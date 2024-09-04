package com.example.projectpatterns.service.interfaces;

import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientResponse;

public interface ClientService {
    ClientResponse save(ClientRequest client);
}
