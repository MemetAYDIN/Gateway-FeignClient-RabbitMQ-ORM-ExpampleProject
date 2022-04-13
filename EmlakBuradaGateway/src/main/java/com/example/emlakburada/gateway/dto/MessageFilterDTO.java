package com.example.emlakburada.gateway.dto;

import java.time.ZonedDateTime;



import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageFilterDTO extends BaseEntityDTO {
    private UserDTO sender;
    private UserDTO receiver;
    private String content;
    private ZonedDateTime sentDate;
}
