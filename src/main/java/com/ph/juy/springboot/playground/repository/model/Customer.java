package com.ph.juy.springboot.playground.repository.model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Entity
public class Customer {

    @Id
    private UUID id;
    private String name;

}
