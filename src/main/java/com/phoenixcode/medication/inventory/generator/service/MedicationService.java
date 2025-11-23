package com.phoenixcode.medication.inventory.generator.service;

import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;

import java.util.List;
import java.util.UUID;

public interface MedicationService {

    List<MedicationResponseDto> getAllMedication(UUID resident_id);
}
