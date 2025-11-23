package com.phoenixcode.medication.inventory.generator.service.impl;

import com.phoenixcode.medication.inventory.generator.domain.dto.CreateMedicationDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;
import com.phoenixcode.medication.inventory.generator.domain.entity.Medication;
import com.phoenixcode.medication.inventory.generator.domain.entity.Resident;
import com.phoenixcode.medication.inventory.generator.repository.MedicationRepository;
import com.phoenixcode.medication.inventory.generator.repository.ResidentRepository;
import com.phoenixcode.medication.inventory.generator.service.MedicationService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.UUID;

public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;
    private final ResidentRepository residentRepository;
    private final ModelMapper modelMapper;

    public MedicationServiceImpl(MedicationRepository medicationRepository, ResidentRepository residentRepository, ModelMapper modelMapper) {
        this.medicationRepository = medicationRepository;
        this.residentRepository = residentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MedicationResponseDto> getAllMedication(UUID resident_id) {

        List<Medication> medications = medicationRepository.findAllByResidentId(resident_id);
        return medications.stream()
                .map(medication -> modelMapper.map(medication, MedicationResponseDto.class))
                .toList();
    }

    @Override
    public MedicationResponseDto createMedication(CreateMedicationDto medicationDto, UUID resident_id) {

        Resident resident = residentRepository.findById(resident_id).get();

        Medication medication = modelMapper.map(medicationDto, Medication.class);
        medication.setResident(resident);

        Medication savedMedication = medicationRepository.save(medication);
        return modelMapper.map(savedMedication, MedicationResponseDto.class);
    }

    @Override
    public MedicationResponseDto getMedication(UUID medication_id) {

        Medication medication = medicationRepository.findById(medication_id).get();
        return modelMapper.map(medication, MedicationResponseDto.class);
    }
}
