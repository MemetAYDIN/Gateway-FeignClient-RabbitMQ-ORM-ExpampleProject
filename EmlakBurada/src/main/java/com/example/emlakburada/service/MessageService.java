package com.example.emlakburada.service;



import com.example.emlakburada.dto.MessageDTO;
import com.example.emlakburada.exception.ServiceException;
import com.example.emlakburada.mapper.MessageMapper;
import com.example.emlakburada.repository.MessageRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    public List<MessageDTO> getAllList() {
        return messageMapper.convertToDTOList(messageRepository.findAll());
    }

    @Transactional
    public MessageDTO create(MessageDTO messageDTO) {
        return messageMapper.convertToDTO(messageRepository.save(messageMapper.convertToEntity(messageDTO)));
    }

    public MessageDTO getMessageById(Long id){
        return messageMapper.convertToDTO(messageRepository.findById(id).
                orElseThrow(() -> new ServiceException(ServiceException.NOT_FOUND,"Message not found")));
    }

    @Transactional
    public MessageDTO update(MessageDTO messageDTO) {
        getMessageById(messageDTO.getId());
        return messageMapper.convertToDTO(messageRepository.save(messageMapper.convertToEntity(messageDTO)));
    }

}
