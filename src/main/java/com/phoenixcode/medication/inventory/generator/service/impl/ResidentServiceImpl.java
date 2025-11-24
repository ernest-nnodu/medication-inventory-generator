package com.phoenixcode.medication.inventory.generator.service.impl;

import com.phoenixcode.medication.inventory.generator.domain.dto.CreateResidentDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.UpdateResidentDto;
import com.phoenixcode.medication.inventory.generator.domain.entity.Resident;
import com.phoenixcode.medication.inventory.generator.repository.ResidentRepository;
import com.phoenixcode.medication.inventory.generator.service.ResidentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    @Override
    public ResidentResponseDto getResident(UUID residentId) {

        Resident resident = residentRepository.findById(residentId).get();
        return modelMapper.map(resident, ResidentResponseDto.class);
    }

    @Override
    public ResidentResponseDto updateResident(UpdateResidentDto residentDto) {

        Resident residentToUpdate = residentRepository.findById(residentDto.getId()).get();

        residentToUpdate.setFirstName(residentDto.getFirstName());
        residentToUpdate.setLastName(residentDto.getLastName());
        residentToUpdate.setServiceName(residentDto.getServiceName());

        Resident updatedResident = residentRepository.save(residentToUpdate);
        return modelMapper.map(updatedResident, ResidentResponseDto.class);
    }

    @Override
    public void deleteResident(UUID residentId) {
        Resident residentToDelete = residentRepository.findById(residentId).get();
        residentRepository.delete(residentToDelete);
    }
}
