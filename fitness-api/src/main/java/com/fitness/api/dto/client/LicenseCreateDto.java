package com.fitness.api.dto.client;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LicenseCreateDto {

    private LocalDateTime startDate;

    private int dayOfLicense;
}
