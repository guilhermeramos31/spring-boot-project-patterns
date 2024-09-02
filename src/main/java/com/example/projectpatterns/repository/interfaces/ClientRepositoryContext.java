package com.example.projectpatterns.repository.interfaces;

import com.example.projectpatterns.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepositoryContext extends JpaRepository<Client, UUID> {
}
