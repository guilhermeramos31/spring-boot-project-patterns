package com.example.projectpatterns.service;


import com.example.projectpatterns.integration.ViaCepService;
import com.example.projectpatterns.integration.model.ViaCepMapper;
import com.example.projectpatterns.model.Address;
import com.example.projectpatterns.model.dto.AddressRequest;
import com.example.projectpatterns.model.mapper.AddressMapper;
import com.example.projectpatterns.service.interfaces.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final ViaCepService viaCepService;
    private final AddressMapper addressMapper;
    private final ViaCepMapper viaCepMapper;

    @Override
    public Address save(AddressRequest address) {
        var cep = viaCepService.consultCEP(address.getZipCode());
        if(cep != null) {
            return viaCepMapper.toModel(cep);
        }
        return addressMapper.toModel(address);
    }
}
