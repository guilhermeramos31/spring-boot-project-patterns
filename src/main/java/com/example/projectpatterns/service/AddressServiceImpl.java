package com.example.projectpatterns.service;


import com.example.projectpatterns.integration.ViaCepService;
import com.example.projectpatterns.integration.model.ViaCepMapper;
import com.example.projectpatterns.model.dto.AddressRequest;
import com.example.projectpatterns.model.dto.AddressResponse;
import com.example.projectpatterns.model.mapper.AddressMapper;
import com.example.projectpatterns.repository.interfaces.AddressRepository;
import com.example.projectpatterns.service.interfaces.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final ViaCepService viaCepService;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    private final ViaCepMapper viaCepMapper;

    @Override
    public AddressResponse save(AddressRequest address) {
        var cep = viaCepService.consultCEP(address.getZipCode());
        if(cep == null) {
            return addressMapper.toDTO(
                    addressRepository.save(
                            addressMapper.toModel(address)));
        }
        return addressMapper.toDTO(addressRepository.save(viaCepMapper.toModel(cep)));
    }
}
