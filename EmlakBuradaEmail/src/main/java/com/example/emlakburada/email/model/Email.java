package com.example.emlakburada.email.model;


import lombok.Data;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    protected Long id;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private ZonedDateTime creatDate;

    @LastModifiedDate
    @Column(nullable = false)
    private ZonedDateTime modificationDate;
    private String senderEmail;
    private String receiverEmail;

}
