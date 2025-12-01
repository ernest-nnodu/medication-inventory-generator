package com.phoenixcode.medication.inventory.generator.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Medication name is required")
    @Size(max = 100, message = "Medication name must not be exceed 100 characters")
    private String name;

    @NotBlank(message = "Medication form is required")
    @Size(max = 50, message = "Medication form must not be exceed 50 characters")
    private String form;

    @NotBlank(message = "Medication strength is required")
    @Size(max = 50, message = "Medication strength must not be exceed 50 characters")
    private String strength;

    @NotBlank(message = "Medication dose is required")
    @Size(max = 200, message = "Medication dose must not be exceed 200 characters")
    private String dose;
}
