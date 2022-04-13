package com.example.emlakburada.banner.mapper;


import com.example.emlakburada.banner.dto.AddressDTO;
import com.example.emlakburada.banner.model.Address;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends Map<Address, AddressDTO>{
}
