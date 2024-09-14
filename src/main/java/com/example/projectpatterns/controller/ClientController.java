package com.example.projectpatterns.controller;

import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientRequestUpdate;
import com.example.projectpatterns.model.dto.ClientResponse;
import com.example.projectpatterns.service.interfaces.ClientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
@Tag(name = "Client")
public class ClientController {
    private final ClientService clientService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client created!"),
            @ApiResponse(responseCode = "409", description = "Client a already exist!"),
            @ApiResponse(responseCode = "500", description = "Something went wrong!"),
    })
    @PostMapping("create")
    public ResponseEntity<ClientResponse> save(@RequestBody ClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(clientRequest));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client updated!"),
            @ApiResponse(responseCode = "404", description = "Client not found!"),
            @ApiResponse(responseCode = "500", description = "Something went wrong!"),
    })
    @PutMapping("update/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable("id") UUID id, @RequestBody ClientRequestUpdate clientRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id,clientRequest));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found!"),
            @ApiResponse(responseCode = "404", description = "Client not found!"),
            @ApiResponse(responseCode = "500", description = "Something went wrong!"),
    })
    @GetMapping("client/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @ApiResponse(responseCode = "200", description = "Clients found!")
    @GetMapping("clients")
    public ResponseEntity<List<ClientResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Client deleted!"),
            @ApiResponse(responseCode = "404", description = "Client not found!"),
            @ApiResponse(responseCode = "500", description = "Something went wrong!")
    })
    @DeleteMapping("delete/client/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clientService.delete(id));
    }
}
