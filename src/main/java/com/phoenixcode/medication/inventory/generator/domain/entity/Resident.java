package com.phoenixcode.medication.inventory.generator.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "residents")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String LastName;
    private String serviceName;

}
