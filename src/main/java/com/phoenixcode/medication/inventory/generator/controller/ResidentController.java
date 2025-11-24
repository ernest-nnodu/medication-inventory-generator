package com.phoenixcode.medication.inventory.generator.controller;

import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentRequestDto;
import com.phoenixcode.medication.inventory.generator.domain.dto.ResidentResponseDto;
import com.phoenixcode.medication.inventory.generator.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<ResidentResponseDto> createResident(@RequestBody ResidentRequestDto residentRequestDto) {

        ResidentResponseDto residentResponseDto = residentService.createResident(residentRequestDto);
        return new ResponseEntity<>(residentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResidentResponseDto> getResident(@PathVariable UUID id) {

        ResidentResponseDto residentResponseDto = residentService.getResident(id);
        return new ResponseEntity<>(residentResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResidentResponseDto> updateResident(@PathVariable UUID id,
                                                              @RequestBody ResidentRequestDto residentRequestDto) {

        ResidentResponseDto residentResponseDto = residentService.updateResident(id, residentRequestDto);
        return new ResponseEntity<>(residentResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteResident(@PathVariable UUID id) {

        residentService.deleteResident(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
