package com.example.projectpatterns.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String zipCode;

    private String street;

    private String additionalInfo;

    private String neighborhood;

    private String city;

    private String state;

    private String ibgeCode;

    private String giaCode;

    private String areaCode;

    private String siafiCode;
}