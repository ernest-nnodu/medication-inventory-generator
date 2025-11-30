package com.phoenixcode.medication.inventory.generator.Exception;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorResponse {

    private LocalDate timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<String> details;
}
