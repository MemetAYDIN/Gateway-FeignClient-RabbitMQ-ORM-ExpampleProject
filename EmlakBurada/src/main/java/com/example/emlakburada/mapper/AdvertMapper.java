package com.example.emlakburada.mapper;


import com.example.emlakburada.dto.AdvertDTO;
import com.example.emlakburada.model.Advert;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {UserMapper.class,AddressMapper.class})
public interface AdvertMapper extends BaseMapper<Advert, AdvertDTO>{
}
