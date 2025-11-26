package com.phoenixcode.medication.inventory.generator.controller;

import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationRequestDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;
import com.phoenixcode.medication.inventory.generator.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/residents/{residentId}/medications")
    public ResponseEntity<MedicationResponseDto> createMedication(@PathVariable UUID residentId,
                                                                  @RequestBody MedicationRequestDto medicationRequestDto) {

        MedicationResponseDto medicationResponseDto = medicationService.createMedication(residentId, medicationRequestDto);
        return new ResponseEntity<>(medicationResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/residents/{residentId}/medications/{medicationId}")
    public ResponseEntity<MedicationResponseDto> getMedication(@PathVariable UUID residentId,
                                                               @PathVariable UUID medicationId) {

        MedicationResponseDto medicationResponseDto = medicationService.getMedication(residentId, medicationId);
        return new ResponseEntity<>(medicationResponseDto, HttpStatus.OK);
    }

    @PutMapping("/residents/{residentId}/medications/{medicationId}")
    public ResponseEntity<MedicationResponseDto> updateMedication(@PathVariable UUID residentId,
                                                                  @PathVariable UUID medicationId,
                                                                  @RequestBody MedicationRequestDto medicationRequestDto) {

        MedicationResponseDto medicationResponseDto = medicationService.updateMedication(
                residentId,
                medicationId,
                medicationRequestDto);

        return new ResponseEntity<>(medicationResponseDto, HttpStatus.OK);
    }
}
