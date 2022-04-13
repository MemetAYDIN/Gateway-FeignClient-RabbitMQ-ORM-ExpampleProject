package com.example.emlakburada.auth.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.emlakburada.auth.enums.UserType;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Data
public class User  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    protected Long id;

    @CreatedDate
    @Column(updatable = false, nullable = true)
    private ZonedDateTime creatDate;

    @LastModifiedDate
    @Column(nullable = true)
    private ZonedDateTime updateDate;
    private String email;
    private String password;
    private UserType userType;
}
