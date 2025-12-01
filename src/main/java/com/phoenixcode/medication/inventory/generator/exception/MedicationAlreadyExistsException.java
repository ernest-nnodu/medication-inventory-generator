package com.phoenixcode.medication.inventory.generator.exception;

public class MedicationAlreadyExistsException extends RuntimeException {

    public MedicationAlreadyExistsException(String message) {
        super(message);
    }
}
