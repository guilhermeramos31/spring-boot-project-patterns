package com.example.projectpatterns.service.interfaces;

import com.example.projectpatterns.model.Address;
import com.example.projectpatterns.model.dto.AddressRequest;

public interface AddressService {
    Address save(AddressRequest address);
}