package com.example.projectpatterns.service;

import com.example.projectpatterns.integration.ViaCepService;
import com.example.projectpatterns.integration.model.ViaCepMapper;
import com.example.projectpatterns.model.mapper.AddressMapper;
import com.example.projectpatterns.service.common.AddressCommon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceImplTest {
    @InjectMocks
    private AddressServiceImpl addressService;

    @Mock
    private AddressMapper addressMapper;

    @Mock
    private ViaCepService viaCepService;

    @Mock
    private ViaCepMapper viaCepMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void SaveAddress_Valid() {
        Mockito.when(viaCepService.consultCEP(AddressCommon.ADDRESS_REQUEST_VALID.getZipCode())).thenReturn(AddressCommon.ADDRESS_DTO_VALID);
        Mockito.when(viaCepMapper.toModel(AddressCommon.ADDRESS_DTO_VALID)).thenReturn(AddressCommon.ADDRESS_VALID);

        var address = addressService.save(AddressCommon.ADDRESS_REQUEST_VALID);

        assertNotNull(address);
        assertEquals(AddressCommon.ADDRESS_VALID, address);

        Mockito.verify(viaCepMapper, Mockito.times(1)).toModel(AddressCommon.ADDRESS_DTO_VALID);
        Mockito.verify(viaCepService, Mockito.times(1)).consultCEP(AddressCommon.ADDRESS_REQUEST_VALID.getZipCode());
    }

    @Test
    void SaveAddress_ViaCep_InValid() {
        Mockito.when(addressMapper.toModel(AddressCommon.ADDRESS_REQUEST_VALID)).thenReturn(AddressCommon.ADDRESS_VALID);

        var address = addressService.save(AddressCommon.ADDRESS_REQUEST_VALID);

        assertNotNull(address);
        assertEquals(AddressCommon.ADDRESS_VALID, address);

        Mockito.verify(addressMapper, Mockito.times(1)).toModel(AddressCommon.ADDRESS_REQUEST_VALID);
    }
}