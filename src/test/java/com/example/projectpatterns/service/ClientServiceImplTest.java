package com.example.projectpatterns.service;


import com.example.projectpatterns.model.mapper.ClientMapper;
import com.example.projectpatterns.repository.interfaces.ClientRepository;
import com.example.projectpatterns.service.common.AddressCommon;
import com.example.projectpatterns.service.common.ClientCommon;
import com.example.projectpatterns.service.interfaces.AddressService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceImplTest {
    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private AddressService addressService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @Mock
    private Validator validator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        var factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void SaveClient_Valid() {
        Mockito.when(clientMapper.toModel(ClientCommon.CLIENT_REQUEST)).thenReturn(ClientCommon.CLIENT_VALID);
        Mockito.when(clientRepository.save(ClientCommon.CLIENT_VALID)).thenReturn(ClientCommon.CLIENT_VALID);
        Mockito.when(clientMapper.toDTO(ClientCommon.CLIENT_VALID)).thenReturn(ClientCommon.CLIENT_RESPONSE);
        Mockito.when(addressService.save(AddressCommon.ADDRESS_REQUEST_VALID)).thenReturn(AddressCommon.ADDRESS_VALID);

        var clientSaved = clientService.save(ClientCommon.CLIENT_REQUEST);

        assertNotNull(clientSaved, "ClientResponse is null");
        assertEquals(ClientCommon.CLIENT_RESPONSE, clientSaved);

        Mockito.verify(clientRepository).save(ClientCommon.CLIENT_VALID);
    }

    @Test
    void SaveClient_NameInvalid() {
        var violations = validator.validate(ClientCommon.CLIENT_REQUEST_NAME_INVALID);

        assertFalse(violations.isEmpty(), "Validation should fail for an empty name.");
        assertThrows(IllegalArgumentException.class, () -> clientService.save(ClientCommon.CLIENT_REQUEST_NAME_INVALID));
    }

    @Test
    void SaveClient_EmailInvalid() {
        var violations = validator.validate(ClientCommon.CLIENT_REQUEST_EMAIL_INVALID);

        assertFalse(violations.isEmpty(), "Validation should fail for an empty email.");
        assertThrows(IllegalArgumentException.class, () -> clientService.save(ClientCommon.CLIENT_REQUEST_EMAIL_INVALID));
    }

    @Test
    void SaveClient_AddressInvalid() {
        var violations = validator.validate(ClientCommon.CLIENT_REQUEST_ADDRESS_INVALID);

        assertFalse(violations.isEmpty(), "Validation should fail for an empty ZipCode.");
        assertThrows(IllegalArgumentException.class, () -> clientService.save(ClientCommon.CLIENT_REQUEST_ADDRESS_INVALID));
    }

    @Test
    void SaveClient_Email_Already_Exist() {
        Mockito.when(clientRepository.findByEmail(ClientCommon.CLIENT_REQUEST.getEmail())).thenReturn(Optional.ofNullable(ClientCommon.CLIENT_VALID));

        assertThrows(EntityExistsException.class, () -> clientService.save(ClientCommon.CLIENT_REQUEST));
    }

    @Test
    void UpdateClient_Valid() {
        Mockito.when(clientRepository.findById(ClientCommon.CLIENT_VALID.getId())).thenReturn(Optional.of(ClientCommon.CLIENT_VALID));
        Mockito.when(clientMapper.toModel(ClientCommon.CLIENT_REQUEST_UPDATE)).thenReturn(ClientCommon.CLIENT_VALID);
        Mockito.when(clientRepository.save(ClientCommon.CLIENT_VALID)).thenReturn(ClientCommon.CLIENT_VALID);
        Mockito.when(clientMapper.toDTO(ClientCommon.CLIENT_VALID)).thenReturn(ClientCommon.CLIENT_RESPONSE);
        Mockito.when(addressService.save(AddressCommon.ADDRESS_REQUEST_VALID)).thenReturn(AddressCommon.ADDRESS_VALID);

        var clientSaved = clientService.update(ClientCommon.CLIENT_RESPONSE.getId(), ClientCommon.CLIENT_REQUEST_UPDATE);

        assertNotNull(clientSaved, "ClientResponse is null");
        assertEquals(ClientCommon.CLIENT_RESPONSE, clientSaved);

        Mockito.verify(clientRepository).save(ClientCommon.CLIENT_VALID);
    }

    @Test
    void UpdateClient_PartialUpdate_NameBlank() {
        Mockito.when(clientRepository.findById(ClientCommon.CLIENT_VALID.getId())).thenReturn(Optional.of(ClientCommon.CLIENT_VALID));
        Mockito.when(clientMapper.toModel(ClientCommon.CLIENT_REQUEST_UPDATE_NAME_INVALID)).thenReturn(ClientCommon.CLIENT_VALID);
        Mockito.when(addressService.save(ClientCommon.CLIENT_REQUEST_UPDATE.getAddress())).thenReturn(ClientCommon.CLIENT_VALID.getAddress());
        Mockito.when(clientRepository.save(ClientCommon.CLIENT_VALID)).thenReturn(ClientCommon.CLIENT_VALID);
        Mockito.when(clientMapper.toDTO(ClientCommon.CLIENT_VALID)).thenReturn(ClientCommon.CLIENT_RESPONSE);

        var updatedClient = clientService.update(ClientCommon.CLIENT_VALID.getId(), ClientCommon.CLIENT_REQUEST_UPDATE_NAME_INVALID);

        assertNotNull(updatedClient);
        assertEquals(ClientCommon.CLIENT_VALID.getName(), updatedClient.getName());

        Mockito.verify(clientRepository).save(ClientCommon.CLIENT_VALID);
    }

    @Test
    void FindClient_Valid() {
        Mockito.when(clientRepository.findById(ClientCommon.CLIENT_VALID.getId())).thenReturn(Optional.of(ClientCommon.CLIENT_VALID));
        Mockito.when(clientMapper.toDTO(ClientCommon.CLIENT_VALID)).thenReturn(ClientCommon.CLIENT_RESPONSE);

        var user = clientService.findById(ClientCommon.CLIENT_VALID.getId());

        assertNotNull(user);
        assertEquals(ClientCommon.CLIENT_RESPONSE, user);

        Mockito.verify(clientRepository).findById(ClientCommon.CLIENT_VALID.getId());
    }

    @Test
    void FindClient_NotFound() {
        Mockito.when(clientRepository.findById(ClientCommon.CLIENT_VALID.getId())).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> clientService.findById(ClientCommon.CLIENT_VALID.getId()));

        Mockito.verify(clientRepository).findById(ClientCommon.CLIENT_VALID.getId());
    }
}