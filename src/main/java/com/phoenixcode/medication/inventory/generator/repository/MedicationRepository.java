package com.phoenixcode.medication.inventory.generator.repository;

import com.phoenixcode.medication.inventory.generator.domain.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, UUID> {
}
