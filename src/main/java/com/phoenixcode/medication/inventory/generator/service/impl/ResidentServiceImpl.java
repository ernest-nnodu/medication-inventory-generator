package com.phoenixcode.medication.inventory.generator.service.impl;

import com.phoenixcode.medication.inventory.generator.domain.dto.CreateResidentDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;
import com.phoenixcode.medication.inventory.generator.domain.entity.Resident;
import com.phoenixcode.medication.inventory.generator.repository.ResidentRepository;
import com.phoenixcode.medication.inventory.generator.service.ResidentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;
    private final ModelMapper modelMapper;

    public ResidentServiceImpl(ResidentRepository residentRepository, ModelMapper modelMapper) {
        this.residentRepository = residentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ResidentResponseDto> getAllResident() {
        List<Resident> residents = residentRepository.findAll();

        return residents.stream()
                .map(resident -> modelMapper.map(resident, ResidentResponseDto.class))
                .toList();
    }

    @Override
    public ResidentResponseDto createResident(CreateResidentDto residentDto) {

        Resident resident = modelMapper.map(residentDto, Resident.class);
        Resident savedResident = residentRepository.save(resident);
        return modelMapper.map(savedResident, ResidentResponseDto.class);
    }
}
