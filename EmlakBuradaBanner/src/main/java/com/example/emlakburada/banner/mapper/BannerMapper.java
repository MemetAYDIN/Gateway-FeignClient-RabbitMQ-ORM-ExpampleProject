package com.example.emlakburada.banner.mapper;


import com.example.emlakburada.banner.dto.BannerDTO;
import com.example.emlakburada.banner.model.Banner;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {AddressMapper.class})
public interface BannerMapper extends Map<Banner, BannerDTO>{
}
