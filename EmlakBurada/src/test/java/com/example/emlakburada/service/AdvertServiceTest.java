package com.example.emlakburada.service;

import com.example.emlakburada.RabbitMq.service.RabbitMqService;
import com.example.emlakburada.client.BannerClient;
import com.example.emlakburada.client.dto.BannerDTO;
import com.example.emlakburada.dto.AdvertDTO;
import com.example.emlakburada.dto.UserDTO;
import com.example.emlakburada.mapper.AdvertMapper;
import com.example.emlakburada.mapper.BannerMapper;
import com.example.emlakburada.model.Advert;
import com.example.emlakburada.model.User;
import com.example.emlakburada.repository.AdvertRepository;
import com.example.emlakburada.service.AdvertService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class AdvertServiceTest {

    @InjectMocks
    private AdvertService advertService;
    @Mock
    private AdvertMapper advertMapper;
    @Mock
    private BannerClient bannerClient;
    @Mock
    private BannerMapper bannerMapper;
    @Mock
    private RabbitMqService rabbitMqService;
    
    @Mock
    private AdvertRepository advertRepository;

    @BeforeEach
    void setup(){
        Mockito
          .when(advertRepository.findAll())
          .thenReturn(prepareTestAdvertList());
        
        Mockito
          .when(advertMapper.convertToDTOList(any()))
          .thenReturn(prepareTestAdvertDTOList());
        
        Mockito
           .when(advertMapper.convertToDTO(any()))
           .thenReturn(prepareTestAdvertDTO());
        Mockito
            .when(advertMapper.convertToEntity(any()))
            .thenReturn(prepareTestAdvert());

    }



  

    @Test
    void create(){
        AdvertDTO advertDTO = prepareTestAdvertDTO();
        Mockito
                .when(bannerClient.save(prepareTestBannerDTO()))
                .thenReturn(new ResponseEntity<BannerDTO>(new BannerDTO(), HttpStatus.OK));
        Mockito
                .when(advertRepository.save(any()))
                .thenReturn(prepareTestAdvert());
        Mockito
                .when(bannerMapper.toDTO(any())).
                thenReturn(prepareTestBannerDTO());

        AdvertDTO advert = advertService.create(advertDTO);
        assertEquals(1984L,advert.getAdvertNo());
        verify(rabbitMqService).sendMessage("mehmet.aydin.bsnss@gmail.com");
        verify(bannerClient).save(any());
    }

    @Test
    void createBanner(){
        Mockito
         .when(bannerMapper.toDTO(any()))
         .thenReturn(prepareTestBannerDTO());
        Mockito
         .when(bannerClient.save(prepareTestBannerDTO()))
         .thenReturn(new ResponseEntity<BannerDTO>(new BannerDTO(), HttpStatus.OK));

        ResponseEntity<BannerDTO> bannerDTOResponseEntity = bannerClient.save(prepareTestBannerDTO());
        assertEquals(200,bannerDTOResponseEntity.getStatusCode().value());
    }

    @Test
    void getAllAdvertTest() {
        List<AdvertDTO> allAdvert = advertService.getAllList();
        assertNotNull(allAdvert);
        assertThat(allAdvert.size()).isNotZero();
    }

    @Test
    void getAdvertById(){
        Mockito.when(advertRepository.findById(any())).thenReturn(java.util.Optional.of(prepareTestAdvert()));
        AdvertDTO advertDTO = advertService.getById(any());
        assertEquals(advertDTO.getId(),1L);
    }



    @Test
    void update(){
        Mockito.when(advertRepository.save(any())).thenReturn(prepareTestAdvert());
        Mockito.when(advertRepository.findById(any())).thenReturn(java.util.Optional.of(prepareTestAdvert()));
        AdvertDTO advert = advertService.update(prepareTestAdvertDTO());
        assertEquals(advert.getId(), 1L);
    }
    
    private List<Advert> prepareTestAdvertList(){
        List<Advert> adverts = new ArrayList<>();
        adverts.add(prepareTestAdvert());
        return adverts;
    }
    private List<AdvertDTO> prepareTestAdvertDTOList(){
        List<AdvertDTO> advertDTOS = new ArrayList<>();
        advertDTOS.add(prepareTestAdvertDTO());
        return advertDTOS;
    }

    private AdvertDTO prepareTestAdvertDTO(){
        AdvertDTO advertDTO = new AdvertDTO();
        UserDTO userDTO = new UserDTO();
        advertDTO.setId(1L);
        advertDTO.setAdvertNo(1984L);
        advertDTO.setActive(true);
        advertDTO.setRealEstateAge(0);
        advertDTO.setCreater(userDTO);
        return advertDTO;
    }

    private BannerDTO prepareTestBannerDTO(){
        BannerDTO bannerDTO = new BannerDTO();
        bannerDTO.setAdvertNo(1984L);
        bannerDTO.setTotal(3);
        return bannerDTO;
    }

    private Advert prepareTestAdvert(){
        Advert advert = new Advert();
        User user = new User();
        advert.setId(1L);
        advert.setAdvertNo(1984L);
        advert.setActive(true);
        advert.setBuildingAge(0);
        advert.setBathRoom(2);
        advert.setOwner(user);
        return advert;
    }
}
