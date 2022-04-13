package com.example.emlakburada.auth.dto;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    protected Long id;

    @CreatedDate
    @Column(updatable = false, nullable = true)
    private ZonedDateTime creatDate;
    
    
	private String token;

}
