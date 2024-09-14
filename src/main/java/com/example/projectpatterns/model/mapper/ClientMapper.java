package com.example.projectpatterns.model.mapper;

import com.example.projectpatterns.model.Client;
import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientRequestUpdate;
import com.example.projectpatterns.model.dto.ClientResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClientMapper {
    private final ModelMapper modelMapper;

    public ClientResponse toDTO(Client client) {
        return modelMapper.map(client, ClientResponse.class);
    }

    public Client toModel(ClientRequest clientResponse) {
        return modelMapper.map(clientResponse, Client.class);
    }

    public Client toModel(ClientRequestUpdate client) {
        return  modelMapper.map(client, Client.class);
    }

    public List<ClientResponse> toDTO(List<Client> clients) {
        return clients.stream().map( client ->  modelMapper.map(client, ClientResponse.class)).toList();
    }
}
