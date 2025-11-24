package com.phoenixcode.medication.inventory.generator.service;

import com.phoenixcode.medication.inventory.generator.domain.dto.CreateMedicationDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.UpdateMedicationDto;

import java.util.List;
import java.util.UUID;

public interface MedicationService {

    List<MedicationResponseDto> getAllMedication(UUID resident_id);
    MedicationResponseDto createMedication(CreateMedicationDto medicationDto, UUID resident_id);
    MedicationResponseDto getMedication(UUID medication_id);
    MedicationResponseDto updateMedication(UpdateMedicationDto medicationDto);
    void deleteMedication(UUID medication_id);
}
