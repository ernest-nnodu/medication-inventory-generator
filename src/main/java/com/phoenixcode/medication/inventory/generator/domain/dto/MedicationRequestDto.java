package com.phoenixcode.medication.inventory.generator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MedicationRequestDto {

    private String name;
    private String form;
    private String strength;
    private String dose;
    private UUID residentId;
}
