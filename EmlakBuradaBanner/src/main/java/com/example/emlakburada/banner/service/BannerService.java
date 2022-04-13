package com.example.emlakburada.banner.service;


import com.example.emlakburada.banner.dto.BannerDTO;
import com.example.emlakburada.banner.exception.GenericServiceException;
import com.example.emlakburada.banner.mapper.BannerMapper;
import com.example.emlakburada.banner.repository.BannerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerMapper bannerMapper;
    private final BannerRepository bannerRepository;

    public List<BannerDTO> getAllList() {
        return bannerMapper.convertToDTOList(bannerRepository.findAll());
    }

    @Transactional
    public BannerDTO create(BannerDTO bannerDTO) {
        return bannerMapper.convertToDTO(bannerRepository.save(bannerMapper.convertToEntity(bannerDTO)));
    }

    public BannerDTO getById(Long id){
        return bannerMapper.convertToDTO(bannerRepository.findById(id).
                orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Banner not found")));
    }

    @Transactional
    public BannerDTO update(BannerDTO bannerDTO) {
        getById(bannerDTO.getId());
        return bannerMapper.convertToDTO(bannerRepository.save(bannerMapper.convertToEntity(bannerDTO)));
    }

    public void delete(Long id){
        bannerMapper.convertToDTO(bannerRepository.findById(id).orElseThrow(() -> new GenericServiceException(GenericServiceException.NOT_FOUND,"Banner not found")));
        bannerRepository.deleteById(id);
    }
}
