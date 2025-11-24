package com.phoenixcode.medication.inventory.generator.controller;

import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;
import com.phoenixcode.medication.inventory.generator.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    public ResponseEntity<List<ResidentResponseDto>> getResidents() {

        List<ResidentResponseDto> residentResponseDtos = residentService.getAllResident();
        return new ResponseEntity<>(residentResponseDtos, HttpStatus.OK);
    }
}
