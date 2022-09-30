package com.stefanjiroveanu.persistance.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "GuiceStudent")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String uuid;
    private String data;

    @PrePersist
    public void persistUuid() {
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
    }
}
