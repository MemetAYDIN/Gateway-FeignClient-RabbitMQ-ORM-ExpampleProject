package com.example.emlakburada.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import com.example.emlakburada.model.enums.AdvertStatus;
import com.example.emlakburada.model.enums.AdvertType;
import com.example.emlakburada.model.enums.Currency;
import com.example.emlakburada.model.enums.RealEstateStatus;
import com.example.emlakburada.model.enums.RealEstateType;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Advert extends BaseEntity implements Serializable {
    private Long advertNo;
    private String title;
    private String description;
    private Integer putFordward;
    private Double price;
    private Integer room;
    private Integer buildingAge;
    private Integer bathRoom;
    private String floor;
    private Integer numberOfFloor;
    private Double m2;
    private AdvertType advertType;
    private AdvertStatus advertStatus;
    private RealEstateType realEstateType;
    private RealEstateStatus realEstateStatus;
    private Boolean active;
    private String roomAndLivingRoom;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private User owner;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> imageList;
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Category mainCategory;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    private Category subCategory;

}
