package com.phoenixcode.medication.inventory.generator.domain.dto;

import com.phoenixcode.medication.inventory.generator.domain.entity.Medication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResidentResponseDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String serviceName;
    private List<Medication> medications;
}
