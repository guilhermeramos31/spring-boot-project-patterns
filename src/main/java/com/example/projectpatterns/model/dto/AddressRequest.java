package com.example.projectpatterns.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    @NotBlank
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
