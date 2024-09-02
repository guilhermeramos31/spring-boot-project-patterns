package com.example.projectpatterns.model.mapper;

import com.example.projectpatterns.model.Address;
import com.example.projectpatterns.model.dto.AddressRequest;
import com.example.projectpatterns.model.dto.AddressResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressMapper {
    private final ModelMapper modelMapper;

    public AddressResponse toDTO(Address address) {
        return modelMapper.map(address, AddressResponse.class);
    }

    public Address toModel(AddressRequest addressResponse) {
        return modelMapper.map(addressResponse, Address.class);
    }

    public List<AddressResponse> toDTO(List<Address> addresses) {
        return addresses.stream().map(address -> modelMapper.map(address, AddressResponse.class) ).toList();
    }
}
