package com.mtzperez.springidea.model.dto;


import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
public class CarDto {
    @NotNull
    @Pattern(regexp = "Coche")
    public String name;

    public CarDto(String name) {
        this.name = name;
    }
}