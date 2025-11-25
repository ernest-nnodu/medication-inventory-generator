package com.phoenixcode.medication.inventory.generator.controller;

import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;
import com.phoenixcode.medication.inventory.generator.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/residents/{residentId}/medications")
    public ResponseEntity<List<MedicationResponseDto>> getMedications(@PathVariable UUID residentId) {

        List<MedicationResponseDto> medicationResponseDtos = medicationService.getAllMedication(residentId);
        return new ResponseEntity<>(medicationResponseDtos, HttpStatus.OK);
    }
}
