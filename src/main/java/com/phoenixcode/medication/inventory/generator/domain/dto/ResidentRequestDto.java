package com.phoenixcode.medication.inventory.generator.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResidentRequestDto {

    private String firstName;
    private String lastName;
    private String serviceName;
}
