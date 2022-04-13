package com.example.emlakburada.email.dto;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class EmailDTO {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    protected Long id;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private ZonedDateTime creatDate;
    private String senderName;
    private Long senderId;
    private String senderEmail;
    private String receiverName;
    private String receiverId;
    private String receiverEmail;

}
