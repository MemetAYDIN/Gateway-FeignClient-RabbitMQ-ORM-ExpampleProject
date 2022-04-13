package com.example.emlakburada.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;
    @ManyToOne(fetch = FetchType.LAZY)
    private User receiver;
    private String content;
    private String title;
    private Boolean seen;
    private ZonedDateTime sentDate;
    private ZonedDateTime readDate;
}
