package com.phoenixcode.medication.inventory.generator.service;

import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationRequestDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;

import java.util.List;
import java.util.UUID;

public interface MedicationService {

    List<MedicationResponseDto> getAllMedication(UUID resident_id);
    MedicationResponseDto createMedication(MedicationRequestDto medicationRequestDto, UUID resident_id);
    MedicationResponseDto getMedication(UUID medication_id);
    MedicationResponseDto updateMedication(UUID medicationId, MedicationRequestDto medicationRequestDto);
    void deleteMedication(UUID medication_id);
}
