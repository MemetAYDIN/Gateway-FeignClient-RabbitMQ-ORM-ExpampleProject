package com.example.emlakburada.mapper;


import com.example.emlakburada.dto.MessageDTO;
import com.example.emlakburada.model.Message;

import org.mapstruct.Mapper;


@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface MessageMapper extends BaseMapper<Message, MessageDTO>{
}
