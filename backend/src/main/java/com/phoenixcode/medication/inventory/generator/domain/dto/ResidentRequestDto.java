package com.phoenixcode.medication.inventory.generator.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResidentRequestDto {

    @NotBlank(message = "Resident first name is required")
    @Size(max = 50, message = "Resident first name must not be exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Resident last name is required")
    @Size(max = 50, message = "Resident last name must not be exceed 50 characters")
    private String lastName;

    @NotBlank(message = "Resident service name is required")
    @Size(max = 100, message = "Resident first name must not be exceed 100 characters")
    private String serviceName;
}
