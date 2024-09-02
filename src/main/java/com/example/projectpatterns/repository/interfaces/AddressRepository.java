package com.example.projectpatterns.repository.interfaces;

import com.example.projectpatterns.model.Address;

import java.util.List;
import java.util.UUID;

public interface AddressRepository {
    void delete(UUID id);
    List<Address> findAll();
    Address findById(UUID id);
    void save(Address address);
    void update(Address address);
}
