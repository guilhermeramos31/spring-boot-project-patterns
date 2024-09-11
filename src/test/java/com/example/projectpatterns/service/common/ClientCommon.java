package com.example.projectpatterns.service.common;

import com.example.projectpatterns.model.Client;
import com.example.projectpatterns.model.dto.*;

import java.util.List;
import java.util.UUID;

public class ClientCommon {
    private static UUID clientId = UUID.randomUUID();

    public static Client CLIENT_VALID = new Client(
            clientId,
            "Wagner Guilherme",
            "test@test.com",
            AddressCommon.ADDRESS_VALID
    );

    public static List<Client> CLIENTS = List.of(
            new Client(
                    UUID.randomUUID(),
                    "Wagner Guilherme",
                    "test@test.com",
                    AddressCommon.ADDRESS_VALID
            ),
            new Client(
                    UUID.randomUUID(),
                    "Ana Silva",
                    "ana.silva@example.com",
                    AddressCommon.ADDRESS_VALID
            ),
            new Client(
                    UUID.randomUUID(),
                    "Carlos Pereira",
                    "carlos.pereira@example.com",
                    AddressCommon.ADDRESS_VALID
            )
    );

    public static List<ClientResponse> CLIENTS_RESPONSE = List.of(
            new ClientResponse(
                    UUID.randomUUID(),
                    "Wagner Guilherme",
                    "test@test.com",
                    AddressCommon.ADDRESS_RESPONSE
            ),
            new ClientResponse(
                    UUID.randomUUID(),
                    "Ana Silva",
                    "ana.silva@example.com",
                    AddressCommon.ADDRESS_RESPONSE
            ),
            new ClientResponse(
                    UUID.randomUUID(),
                    "Carlos Pereira",
                    "carlos.pereira@example.com",
                    AddressCommon.ADDRESS_RESPONSE
            )
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
            clientId,
            CLIENT_VALID.getName(),
            CLIENT_VALID.getEmail(),
            AddressCommon.ADDRESS_RESPONSE
    );

    public static ClientRequestUpdate CLIENT_REQUEST_UPDATE = new ClientRequestUpdate(
            CLIENT_VALID.getName(),
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
    public static ClientRequest CLIENT_REQUEST_ADDRESS_INVALID = new ClientRequest(
            CLIENT_VALID.getName(),
            "",
            AddressCommon.ADDRESS_REQUEST_INVALID
    );

    public static ClientRequestUpdate CLIENT_REQUEST_UPDATE_NAME_INVALID = new ClientRequestUpdate(
            "",
            AddressCommon.ADDRESS_REQUEST_VALID
    );

    public static ClientRequestUpdate CLIENT_REQUEST_UPDATE_ADDRESS_INVALID = new ClientRequestUpdate(
            CLIENT_VALID.getName(),
            AddressCommon.ADDRESS_REQUEST_INVALID
    );
}
