package com.example.projectpatterns.service.common;

import com.example.projectpatterns.integration.model.AddressDTO;
import com.example.projectpatterns.model.Address;
import com.example.projectpatterns.model.dto.AddressRequest;
import com.example.projectpatterns.model.dto.AddressResponse;

import java.util.UUID;

public class AddressCommon {
    private static UUID addressId = UUID.randomUUID();

    public static Address ADDRESS_VALID = new Address(
            addressId,
            "60000000",
            "Main Street",
            "Apt 101",
            "Central Park",
            "New City",
            "StateX",
            "123456",
            "654321",
            "11",
            "1234"
    );

    public static Address ADDRESS_INVALID = new Address(
            addressId,
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    );

    public static AddressRequest ADDRESS_REQUEST_VALID = new AddressRequest(
            "60000000",
            "Main Street",
            "Apt 101",
            "Central Park",
            "New City",
            "StateX",
            "123456",
            "654321",
            "11",
            "1234"
    );

    public static AddressRequest ADDRESS_REQUEST_INVALID = new AddressRequest(
            "",
            "Main Street",
            "Apt 101",
            "Central Park",
            "New City",
            "StateX",
            "123456",
            "654321",
            "11",
            "1234"
    );

    public static AddressResponse ADDRESS_RESPONSE = new AddressResponse(
            "60000000",
            "Main Street",
            "Apt 101",
            "Central Park",
            "New City",
            "StateX",
            "123456",
            "654321",
            "11",
            "1234"
    );

    public static AddressDTO ADDRESS_DTO_VALID = new AddressDTO(
            "60000000",
            "Main Street",
            "Apt 101",
            "Central Park",
            "New City",
            "StateX",
            "EstadoY",
            "RegionZ",
            "123456",
            "654321",
            "",
            "11",
            "1234"
    );
}
