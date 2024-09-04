package com.example.projectpatterns.integration.model;

import com.example.projectpatterns.model.Address;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ViaCepMapper {
    private final ModelMapper modelMapper;

    public Address toModel(AddressDTO addressDTO) {
        return modelMapper.map(addressDTO, Address.class);
    }
}
