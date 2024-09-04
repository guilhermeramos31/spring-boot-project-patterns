package com.example.projectpatterns.service.common;

import com.example.projectpatterns.model.Client;
import com.example.projectpatterns.model.dto.AddressRequest;
import com.example.projectpatterns.model.dto.AddressResponse;
import com.example.projectpatterns.model.dto.ClientRequest;
import com.example.projectpatterns.model.dto.ClientResponse;

import java.util.UUID;

public class ClientCommon {
    private static UUID clientId = UUID.randomUUID();

    public static Client CLIENT_VALID = new Client(
            clientId,
            "Wagner Guilherme",
            "test@test.com",
            AddressCommon.ADDRESS_VALID
    );

    public static ClientRequest CLIENT_REQUEST = new ClientRequest(
            CLIENT_VALID.getName(),
            CLIENT_VALID.getEmail(),
            new AddressRequest(
                    AddressCommon.ADDRESS_VALID.getZipCode(),
                    AddressCommon.ADDRESS_VALID.getStreet(),
                    AddressCommon.ADDRESS_VALID.getAdditionalInfo(),
                    AddressCommon.ADDRESS_VALID.getNeighborhood(),
                    AddressCommon.ADDRESS_VALID.getCity(),
                    AddressCommon.ADDRESS_VALID.getState(),
                    AddressCommon.ADDRESS_VALID.getIbgeCode(),
                    AddressCommon.ADDRESS_VALID.getGiaCode(),
                    AddressCommon.ADDRESS_VALID.getAreaCode(),
                    AddressCommon.ADDRESS_VALID.getSiafiCode()
            )
    );

    public static ClientResponse CLIENT_RESPONSE = new ClientResponse(
            CLIENT_VALID.getName(),
            CLIENT_VALID.getEmail(),
            new AddressResponse(
                    AddressCommon.ADDRESS_VALID.getZipCode(),
                    AddressCommon.ADDRESS_VALID.getStreet(),
                    AddressCommon.ADDRESS_VALID.getAdditionalInfo(),
                    AddressCommon.ADDRESS_VALID.getNeighborhood(),
                    AddressCommon.ADDRESS_VALID.getCity(),
                    AddressCommon.ADDRESS_VALID.getState(),
                    AddressCommon.ADDRESS_VALID.getIbgeCode(),
                    AddressCommon.ADDRESS_VALID.getGiaCode(),
                    AddressCommon.ADDRESS_VALID.getAreaCode(),
                    AddressCommon.ADDRESS_VALID.getSiafiCode()
            )
    );

    public static ClientRequest CLIENT_REQUEST_NAME_INVALID = new ClientRequest(
            "",
            CLIENT_REQUEST.getEmail(),
            AddressCommon.ADDRESS_REQUEST_VALID
    );

    public static ClientRequest CLIENT_REQUEST_EMAIL_INVALID = new ClientRequest(
            CLIENT_VALID.getName(),
            "",
            AddressCommon.ADDRESS_REQUEST_VALID
    );
}
