package com.ph.juy.springboot.playground.repository.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
