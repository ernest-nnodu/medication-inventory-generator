package com.phoenixcode.medication.inventory.generator.controller;

import com.phoenixcode.medication.inventory.generator.domain.dto.CreateResidentDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;
import com.phoenixcode.medication.inventory.generator.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ResidentResponseDto> createResident(@RequestBody CreateResidentDto residentDto) {

        ResidentResponseDto residentResponseDto = residentService.createResident(residentDto);
        return new ResponseEntity<>(residentResponseDto, HttpStatus.CREATED);
    }
}
