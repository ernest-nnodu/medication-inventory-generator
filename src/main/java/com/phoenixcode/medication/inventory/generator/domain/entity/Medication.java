package com.phoenixcode.medication.inventory.generator.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "medications")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String form;
    private String strength;
    private String dose;

    @ManyToOne
    @JoinColumn(name = "resident_id")
    private Resident resident;
}
