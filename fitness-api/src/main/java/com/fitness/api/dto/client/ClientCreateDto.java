package com.fitness.api.dto.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ClientCreateDto {
    @NotBlank
    @Size(min = 2, max = 50)
    private String username;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;

    @Size(min = 2, max = 50)
    private String name;

    @NotBlank
    @Pattern(regexp = "^(.+)@(\\S+)$")
    private String email;

    @NotBlank
    private String phone;

    private CharacteristicDto characteristicDto;

    private int dayOfLicense;
}
