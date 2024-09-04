package com.example.projectpatterns.repository.interfaces;

import com.example.projectpatterns.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepositoryContext extends JpaRepository<Address, UUID> {
}
