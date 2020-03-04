package com.mtzperez.springidea.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    private String name;

    public Car(String name) {
        this.name = name;
    }
}
