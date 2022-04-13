package com.example.emlakburada.gateway.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageDTO extends BaseEntityDTO{
    private UserDTO sender;
    private UserDTO receiver;
    private String content;
    private String title;
    private Boolean seen;
    private ZonedDateTime sentDate;
    private ZonedDateTime readDate;
}
