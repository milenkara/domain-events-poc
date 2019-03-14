package com.kolotree.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private AddressDto address;
}
