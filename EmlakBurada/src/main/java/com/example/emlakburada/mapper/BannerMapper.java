package com.example.emlakburada.mapper;


import com.example.emlakburada.client.dto.BannerDTO;
import com.example.emlakburada.model.Advert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface BannerMapper{
    @Named("toDTO")
    @Mapping(target="advertNo", source="advertNo")
    @Mapping(target="address", source="address")
    @Mapping(target="phone", source="owner.phoneNumber")
    BannerDTO toDTO(Advert entity);
}
