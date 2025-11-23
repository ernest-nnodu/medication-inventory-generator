package com.phoenixcode.medication.inventory.generator.service;

import com.phoenixcode.medication.inventory.generator.domain.dto.CreateResidentDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.UpdateResidentDto;

import java.util.List;
import java.util.UUID;

public interface ResidentService {

    List<ResidentResponseDto> getAllResident();
    ResidentResponseDto createResident(CreateResidentDto residentDto);
    ResidentResponseDto updateResident(UpdateResidentDto residentDto);
    void deleteResident(UUID residentId);
}
