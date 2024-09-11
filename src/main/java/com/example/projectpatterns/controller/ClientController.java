package com.example.projectpatterns.controller;

import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientRequestUpdate;
import com.example.projectpatterns.model.dto.ClientResponse;
import com.example.projectpatterns.service.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {
    private final ClientService clientService;

    @PostMapping("create")
    public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(clientRequest));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable("id") UUID id, @RequestBody ClientRequestUpdate clientRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id,clientRequest));
    }

    @GetMapping("client/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @DeleteMapping("delete/client/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientService.delete(id));
    }
}
