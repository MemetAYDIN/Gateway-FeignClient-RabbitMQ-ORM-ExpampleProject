package com.example.emlakburada.gateway.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ImageDTO extends BaseEntityDTO{
    private String path;
    private Integer sort;
}
