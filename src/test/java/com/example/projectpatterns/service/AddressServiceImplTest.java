package com.example.projectpatterns.service;

import com.example.projectpatterns.model.Address;
import com.example.projectpatterns.repository.interfaces.AddressRepository;
import com.example.projectpatterns.service.common.AddressCommon;
import com.example.projectpatterns.service.interfaces.AddressService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceImplTest {
    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    void SaveAddress_Valid() {
        var address = AddressCommon.ADDRESS_VALID;

        Mockito.when(addressRepository.save(Mockito.any(Address.class))).thenReturn(address);
    }
}