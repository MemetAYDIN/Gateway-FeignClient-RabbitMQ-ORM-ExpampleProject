package com.example.emlakburada.service;


import com.example.emlakburada.dto.UserDTO;
import com.example.emlakburada.exception.ServiceException;
import com.example.emlakburada.mapper.UserMapper;
import com.example.emlakburada.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public List<UserDTO> getAllList() {
        return userMapper.convertToDTOList(userRepository.findAll());
    }

    @Transactional
    public UserDTO create(UserDTO userDTO) {
        return userMapper.convertToDTO(userRepository.save(userMapper.convertToEntity(userDTO)));
    }

    public UserDTO getUserById(Long id){
        return userMapper.convertToDTO(userRepository.findById(id).
                orElseThrow(() -> new ServiceException(ServiceException.NOT_FOUND,"User not found")));
    }

    @Transactional
    public UserDTO update(UserDTO userDTO) {
        getUserById(userDTO.getId());
        return userMapper.convertToDTO(userRepository.save(userMapper.convertToEntity(userDTO)));
    }

}
