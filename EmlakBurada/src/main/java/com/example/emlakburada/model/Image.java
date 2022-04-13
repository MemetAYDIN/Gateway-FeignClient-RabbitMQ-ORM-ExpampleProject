package com.example.emlakburada.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Image  extends BaseEntity  implements Serializable {
    private String path;
    private Integer sort;
}
