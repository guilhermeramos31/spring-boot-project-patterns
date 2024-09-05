package com.example.projectpatterns.controller;

import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientResponse;
import com.example.projectpatterns.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("create")
    public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(clientRequest));
    }
}
