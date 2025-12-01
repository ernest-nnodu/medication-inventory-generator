package com.phoenixcode.medication.inventory.generator.repository;

import com.phoenixcode.medication.inventory.generator.domain.entity.Medication;
import com.phoenixcode.medication.inventory.generator.domain.entity.Resident;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, UUID> {

    List<Medication> findAllByResidentId(UUID resident_id);
    Optional<Medication> findByIdAndResidentId(UUID medicationId, UUID residentId);

    boolean existsByNameAndStrength(String name, String strength);
}
