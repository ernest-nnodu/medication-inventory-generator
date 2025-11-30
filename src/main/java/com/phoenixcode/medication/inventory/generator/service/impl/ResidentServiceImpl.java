package com.phoenixcode.medication.inventory.generator.service.impl;

import com.phoenixcode.medication.inventory.generator.Exception.ResidentNotFoundException;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentRequestDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;
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
    public ResidentResponseDto createResident(ResidentRequestDto residentRequestDto) {

        Resident resident = modelMapper.map(residentRequestDto, Resident.class);
        Resident savedResident = residentRepository.save(resident);
        return modelMapper.map(savedResident, ResidentResponseDto.class);
    }

    @Override
    public ResidentResponseDto getResident(UUID residentId) {

        Resident resident = getExisitingResident(residentId);

        return modelMapper.map(resident, ResidentResponseDto.class);
    }

    @Override
    public ResidentResponseDto updateResident(UUID residentId, ResidentRequestDto residentRequestDto) {

        Resident residentToUpdate = getExisitingResident(residentId);

        residentToUpdate.setFirstName(residentRequestDto.getFirstName());
        residentToUpdate.setLastName(residentRequestDto.getLastName());
        residentToUpdate.setServiceName(residentRequestDto.getServiceName());

        Resident updatedResident = residentRepository.save(residentToUpdate);
        return modelMapper.map(updatedResident, ResidentResponseDto.class);
    }

    @Override
    public void deleteResident(UUID residentId) {
        Resident residentToDelete = getExisitingResident(residentId);
        residentRepository.delete(residentToDelete);
    }

    private Resident getExisitingResident(UUID residentId) {

        return residentRepository.findById(residentId).orElseThrow(
                () -> new ResidentNotFoundException("Resident not found with Id: " + residentId)
        );
    }

}
