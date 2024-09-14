package com.example.projectpatterns.service;

import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientRequestUpdate;
import com.example.projectpatterns.model.dto.ClientResponse;
import com.example.projectpatterns.model.mapper.ClientMapper;
import com.example.projectpatterns.repository.interfaces.ClientRepository;
import com.example.projectpatterns.service.interfaces.AddressService;
import com.example.projectpatterns.service.interfaces.ClientService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        if (client.getAddress().getZipCode().isBlank()) {
            throw new IllegalArgumentException("ZipCode cannot be blank");
        }

        var clientFound = clientRepository.findByEmail(client.getEmail());
        if (clientFound.isPresent()) {
            throw new EntityExistsException("Client with this email already exists");
        }

        var clientModel = clientMapper.toModel(client);
        clientModel.setAddress(addressService.save(client.getAddress()));
        return clientMapper.toDTO(clientRepository.save(clientModel));
    }

    @Override
    public ClientResponse update(UUID id, ClientRequestUpdate client) {
        var clientFound = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        if (client.getName().isBlank()) {
            client.setName(clientFound.getName());
        }
        if (client.getAddress().getZipCode().isBlank()) {
            client.getAddress().setZipCode(clientFound.getAddress().getZipCode());
        }

        var clientModel = clientMapper.toModel(client);
        clientModel.setId(id);
        clientModel.setName(client.getName());
        clientModel.setEmail(clientFound.getEmail());
        clientModel.setAddress(addressService.save(client.getAddress()));

        return clientMapper.toDTO(clientRepository.save(clientModel));
    }

    @Override
    public ClientResponse findById(UUID id) {
        var clientFound = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        return clientMapper.toDTO(clientFound);
    }

    @Override
    public String delete(UUID id) {
        var clientFound = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        String message;
        if (clientFound != null) {
            clientRepository.delete(clientFound.getId());
            message = "Client deleted successfully!";
        } else {
            message = "Client not deleted!";
        }
        return message;
    }

    @Override
    public List<ClientResponse> findAll() {
        return clientMapper.toDTO(clientRepository.findAll());
    }
}
