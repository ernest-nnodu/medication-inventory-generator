package com.phoenixcode.medication.inventory.generator.repository;

import com.phoenixcode.medication.inventory.generator.domain.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, UUID> {

    boolean existsByFirstNameAndLastNameAndServiceName(String firstName, String lastName, String serviceName);
}
