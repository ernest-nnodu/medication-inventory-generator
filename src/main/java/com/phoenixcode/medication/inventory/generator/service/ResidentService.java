package com.phoenixcode.medication.inventory.generator.service;

import com.phoenixcode.medication.inventory.generator.domain.dto.CreateResidentDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;

import java.util.List;

public interface ResidentService {

    List<ResidentResponseDto> getAllResident();
    ResidentResponseDto createResident(CreateResidentDto residentDto);
}
