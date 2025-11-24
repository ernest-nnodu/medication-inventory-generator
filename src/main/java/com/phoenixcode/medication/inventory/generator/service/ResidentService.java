package com.phoenixcode.medication.inventory.generator.service;

import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentRequestDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;

import java.util.List;
import java.util.UUID;

public interface ResidentService {

    List<ResidentResponseDto> getAllResident();
    ResidentResponseDto createResident(ResidentRequestDto residentRequestDto);
    ResidentResponseDto getResident(UUID residentId);
    ResidentResponseDto updateResident(UUID residentId, ResidentRequestDto residentRequestDto);
    void deleteResident(UUID residentId);
}
