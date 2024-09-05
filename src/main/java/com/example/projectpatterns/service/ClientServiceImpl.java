package com.example.projectpatterns.service;

import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientResponse;
import com.example.projectpatterns.model.mapper.ClientMapper;
import com.example.projectpatterns.repository.interfaces.ClientRepository;
import com.example.projectpatterns.service.interfaces.AddressService;
import com.example.projectpatterns.service.interfaces.ClientService;
import jakarta.persistence.EntityExistsException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final AddressService addressService;

    @Override
    public ClientResponse save(@Valid ClientRequest client) {
        if (client.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (client.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }

        var clientFound = clientRepository.findByEmail(client.getEmail());
        if (clientFound.isPresent()) {
            throw new EntityExistsException("Client with this email already exists");
        }

        var clientModel = clientMapper.toModel(client);
        clientModel.setAddress(addressService.save(client.getAddress()));
        return clientMapper.toDTO(clientRepository.save(clientModel));
    }
}
