package com.example.emlakburada.service;



import com.example.emlakburada.RabbitMq.service.RabbitMqService;
import com.example.emlakburada.client.BannerClient;
import com.example.emlakburada.client.dto.BannerDTO;
import com.example.emlakburada.dto.AdvertDTO;
import com.example.emlakburada.exception.ServiceException;
import com.example.emlakburada.mapper.AdvertMapper;
import com.example.emlakburada.mapper.BannerMapper;
import com.example.emlakburada.model.Advert;
import com.example.emlakburada.repository.AdvertRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertMapper advertMapper;
    private final BannerClient bannerClient;
    private final BannerMapper bannerMapper;
    private final RabbitMqService rabbitMqService;
    private final AdvertRepository advertRepository;

    public List<AdvertDTO> getAllList() {
        return advertMapper.convertToDTOList(advertRepository.findAll());
    }

    @Transactional
    public AdvertDTO create(AdvertDTO advertDTO) {
        advertDTO.setAdvertNo((long) (1 + new Random().nextInt(900000000)));
        Advert advert = advertRepository.save(advertMapper.convertToEntity(advertDTO));
        createBanner(advertDTO);
        rabbitMqService.sendMessage(advertDTO.getCreater().getEmail());
        return advertMapper.convertToDTO(advert);
    }

    public void createBanner(AdvertDTO advertDTO){
        BannerDTO bannerDTO = bannerMapper.toDTO(advertMapper.convertToEntity(advertDTO));
        bannerDTO.setTotal(1);
        bannerDTO.setPhone(advertDTO.getCreater().getPhoneNumber());
        bannerDTO.setAdvertNo(advertDTO.getAdvertNo());
        bannerDTO.setAddress(advertDTO.getAddress());
        bannerClient.save(bannerDTO);
    }

    @Transactional
    public AdvertDTO update(AdvertDTO advertDTO) {
        getById(advertDTO.getId());
        return advertMapper.convertToDTO(advertRepository.save(advertMapper.convertToEntity(advertDTO)));
    }


    public AdvertDTO getById(Long id){
        return advertMapper.convertToDTO(advertRepository.findById(id).orElseThrow(() -> new ServiceException(ServiceException.NOT_FOUND,"Advert not found")));
    }


}
