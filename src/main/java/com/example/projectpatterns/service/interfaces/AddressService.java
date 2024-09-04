package com.example.projectpatterns.service.interfaces;

import com.example.projectpatterns.model.dto.AddressRequest;
import com.example.projectpatterns.model.dto.AddressResponse;
import org.springframework.stereotype.Service;

public interface AddressService {
    AddressResponse save(AddressRequest address);
}