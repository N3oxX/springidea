package com.mtzperez.springidea.model.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
public class CarDto {
    @NotNull
    @NotBlank
    @Getter
    @Pattern(regexp = "^[a-zA-Z ]*$")
    public String name;

    public CarDto(String name) {
        this.name = name;
    }
}