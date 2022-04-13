package com.example.emlakburada.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import com.example.emlakburada.model.enums.AdvertStatus;
import com.example.emlakburada.model.enums.AdvertType;
import com.example.emlakburada.model.enums.Currency;
import com.example.emlakburada.model.enums.RealEstateStatus;
import com.example.emlakburada.model.enums.RealEstateType;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdvertDTO extends BaseEntityDTO{
    private Long advertNo;
    private String title;
    private String description;
    private Integer putFordward;
    private Double price;
    private Integer room;
    private Integer realEstateAge;
    private String floor;
    private Integer numberOfFloor;
    private Double netSquareMeters;
    private Double squareMeters;
    private Boolean active;
    private UserDTO creater;
    private List<ImageDTO> imageList;
    private AddressDTO address;
    private CategoryDTO mainCategory;
    private CategoryDTO subCategory;
    private AdvertType advertType;
    private AdvertStatus advertStatus;
    private RealEstateType realEstateType;
    private RealEstateStatus realEstateStatus; 
    private Currency currency;
}
