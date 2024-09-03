package com.example.projectpatterns.repository;

import com.example.projectpatterns.model.Address;
import com.example.projectpatterns.repository.interfaces.AddressRepository;
import com.example.projectpatterns.repository.interfaces.AddressRepositoryContext;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class AddressRepositoryImpl implements AddressRepository {
    private final AddressRepositoryContext repository;

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Address> findAll() {
        return repository.findAll();
    }

    @Override
    public Address findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Address not found"));
    }

    @Override
    public Address save(Address address) {
        return repository.save(address);
    }
}
