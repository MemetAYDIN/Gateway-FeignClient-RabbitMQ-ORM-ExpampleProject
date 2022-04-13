package com.example.emlak_burada_banner.service;

import com.example.emlakburada.banner.dto.AddressDTO;
import com.example.emlakburada.banner.dto.BannerDTO;
import com.example.emlakburada.banner.mapper.BannerMapper;
import com.example.emlakburada.banner.model.Address;
import com.example.emlakburada.banner.model.Banner;
import com.example.emlakburada.banner.repository.BannerRepository;
import com.example.emlakburada.banner.service.BannerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class BannerServiceTest {
    @InjectMocks
    private BannerService bannerService;
    @Mock
    private BannerMapper bannerMapper;
    @Mock
    private BannerRepository bannerRepository;

    @BeforeEach
    void setup(){
        Mockito
                .when(bannerRepository.findAll())
                .thenReturn(prepareMockBannerList());
        Mockito
                .when(bannerMapper.convertToDTOList(any()))
                .thenReturn(prepareMockBannerDTOList());
        Mockito
                .when(bannerMapper.convertToDTO(any()))
                .thenReturn(prepareMockBannerDTO());
        Mockito
                .when(bannerMapper.convertToEntity(any())).
                thenReturn(prepareMockBanner());
    }

    private List<Banner> prepareMockBannerList(){
        List<Banner> bannerList = new ArrayList<>();
        bannerList.add(prepareMockBanner());
        return bannerList;
    }

    private Banner prepareMockBanner(){
        Banner banner = new Banner();
        Address address = new Address();
        address.setFullAddress("....");
        banner.setId(1L);
        banner.setAddress(address);
        return banner;
    }

    private List<BannerDTO> prepareMockBannerDTOList(){
        List<BannerDTO> bannerDTOS = new ArrayList<>();
        bannerDTOS.add(prepareMockBannerDTO());
        return bannerDTOS;
    }

    private BannerDTO prepareMockBannerDTO(){
        BannerDTO banner = new BannerDTO();
        AddressDTO address = new AddressDTO();
        address.setFullAddress("....");
        banner.setId(1L);
        banner.setAddress(address);
        return banner;
    }

    @Test
    void getAllUserTest() {
        List<BannerDTO> allBanner = bannerService.getAllList();
        assertNotNull(allBanner);
        assertThat(allBanner.size()).isNotZero();
    }

    @Test
    void create(){
        Mockito.when(bannerRepository.save(any())).thenReturn(prepareMockBanner());
        BannerDTO bannerDTO = bannerService.create(prepareMockBannerDTO());
        assertEquals(bannerDTO.getId(), 1L);
    }

    @Test
    void getById(){
        Mockito.when(bannerRepository.findById(prepareMockBannerDTO().getId())).thenReturn(java.util.Optional.of(prepareMockBanner()));
        BannerDTO bannerDTO = bannerService.getById(prepareMockBannerDTO().getId());
        assertEquals(bannerDTO.getId(),1L);
    }

    @Test
    void update(){
        Mockito.when(bannerRepository.save(any())).thenReturn(prepareMockBanner());
        Mockito.when(bannerRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMockBanner()));
        BannerDTO bannerDTO = bannerService.update(prepareMockBannerDTO());
        assertEquals(bannerDTO.getId(), 1L);
    }

    @Test
    void delete(){
        BannerDTO bannerDTO = prepareMockBannerDTO();
        Mockito.when(bannerRepository.findById(any())).thenReturn(java.util.Optional.of(prepareMockBanner()));
        doNothing().when(bannerRepository).deleteById(bannerDTO.getId());
        bannerService.delete(bannerDTO.getId());
        verify(bannerRepository).deleteById(bannerDTO.getId());
    }

}
