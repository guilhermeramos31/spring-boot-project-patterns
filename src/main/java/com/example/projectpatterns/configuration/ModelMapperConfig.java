package com.example.projectpatterns.configuration;

import com.example.projectpatterns.integration.model.AddressDTO;
import com.example.projectpatterns.model.Address;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<AddressDTO, Address>() {
            @Override
            protected void configure() {
                map().setZipCode(source.getCep());
                map().setStreet(source.getLogradouro());
                map().setAdditionalInfo(source.getComplemento());
                map().setNeighborhood(source.getBairro());
                map().setCity(source.getLocalidade());
                map().setState(source.getUf());
                map().setIbgeCode(source.getIbge());
                map().setGiaCode(source.getGia());
                map().setAreaCode(source.getDdd());
                map().setSiafiCode(source.getSiafi());
            }
        });

        return modelMapper;
    }
}
