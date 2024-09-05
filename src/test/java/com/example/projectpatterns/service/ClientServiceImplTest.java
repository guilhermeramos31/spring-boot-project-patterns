package com.example.projectpatterns.service;


import com.example.projectpatterns.model.mapper.ClientMapper;
import com.example.projectpatterns.repository.interfaces.ClientRepository;
import com.example.projectpatterns.service.common.AddressCommon;
import com.example.projectpatterns.service.common.ClientCommon;
import com.example.projectpatterns.service.interfaces.AddressService;
import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


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
}