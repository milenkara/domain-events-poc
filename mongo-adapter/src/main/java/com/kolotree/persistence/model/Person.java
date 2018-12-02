package com.kolotree.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Address address;
}
