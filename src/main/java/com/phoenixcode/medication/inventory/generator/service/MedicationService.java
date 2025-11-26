package com.phoenixcode.medication.inventory.generator.service;

import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationRequestDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;

import java.util.List;
import java.util.UUID;

public interface MedicationService {

    List<MedicationResponseDto> getAllMedication(UUID resident_id);
    MedicationResponseDto createMedication(UUID resident_id, MedicationRequestDto medicationRequestDto);
    MedicationResponseDto getMedication(UUID residentId, UUID medication_id);
    MedicationResponseDto updateMedication(UUID residentId, UUID medicationId, MedicationRequestDto medicationRequestDto);
    void deleteMedication(UUID medication_id);
}
