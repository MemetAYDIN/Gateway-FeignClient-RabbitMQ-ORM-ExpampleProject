package com.example.emlakburada.mapper;


import com.example.emlakburada.dto.AddressDTO;
import com.example.emlakburada.model.Address;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDTO>{
}
