package com.example.emlakburada.client.dto;

import com.example.emlakburada.dto.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class BannerDTO extends BaseEntityDTO {
    private Long advertNo;
    private String phone;
    private int total;
    private AddressDTO address;
}
