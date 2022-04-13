package com.example.emlakburada.banner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    protected Long id;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private ZonedDateTime creatDate;

    @LastModifiedDate
    @Column(nullable = false)
    private ZonedDateTime updateDate;
    
    private String province;
    private String district;
    private String fullAddress;

}
