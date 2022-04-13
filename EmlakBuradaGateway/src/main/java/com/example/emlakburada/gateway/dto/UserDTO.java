package com.example.emlakburada.gateway.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

import com.example.emlakburada.gateway.enums.UserType;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseEntityDTO {
    private UserType userType;
    private String name;
    private String surname;
    private String email;
    private String path;
    private String phoneNumber;
    private String officePhone;
    private String vkn;

    private Set<AdvertDTO> favorite;
}
