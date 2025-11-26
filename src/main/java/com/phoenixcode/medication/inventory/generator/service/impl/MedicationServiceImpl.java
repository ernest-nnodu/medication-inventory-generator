package com.phoenixcode.medication.inventory.generator.service.impl;

import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationRequestDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.MedicationResponseDto;
import com.phoenixcode.medication.inventory.generator.domain.entity.Medication;
import com.phoenixcode.medication.inventory.generator.domain.entity.Resident;
import com.phoenixcode.medication.inventory.generator.repository.MedicationRepository;
import com.phoenixcode.medication.inventory.generator.repository.ResidentRepository;
import com.phoenixcode.medication.inventory.generator.service.MedicationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
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
    public MedicationResponseDto createMedication(UUID resident_id, MedicationRequestDto medicationRequestDto) {

        Resident resident = residentRepository.findById(resident_id).get();

        Medication medication = modelMapper.map(medicationRequestDto, Medication.class);
        medication.setResident(resident);

        Medication savedMedication = medicationRepository.save(medication);
        return modelMapper.map(savedMedication, MedicationResponseDto.class);
    }

    @Override
    public MedicationResponseDto getMedication(UUID residentId, UUID medicationId) {

        Medication medication = medicationRepository.findByIdAndResidentId(medicationId, residentId).get();
        return modelMapper.map(medication, MedicationResponseDto.class);
    }

    @Override
    public MedicationResponseDto updateMedication(UUID residentId, UUID medicationId, MedicationRequestDto medicationRequestDto) {

        Medication medicationToUpdate = medicationRepository.findByIdAndResidentId(medicationId, residentId).get();
        medicationToUpdate.setName(medicationRequestDto.getName());
        medicationToUpdate.setForm(medicationRequestDto.getForm());
        medicationToUpdate.setStrength(medicationRequestDto.getStrength());
        medicationToUpdate.setDose(medicationRequestDto.getDose());

        Medication savedMedication = medicationRepository.save(medicationToUpdate);
        return modelMapper.map(savedMedication, MedicationResponseDto.class);
    }

    @Override
    public void deleteMedication(UUID residentId, UUID medication_id) {
        Medication medicationToDelete = medicationRepository.findByIdAndResidentId(medication_id, residentId).get();
        medicationRepository.delete(medicationToDelete);
    }
}
