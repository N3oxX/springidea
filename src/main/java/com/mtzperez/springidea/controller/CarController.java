package com.mtzperez.springidea.controller;

import com.mtzperez.springidea.model.dto.CarDto;
import com.mtzperez.springidea.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService carService;


    @GetMapping
    @Profile("dev")
    public List<CarDto> getAll() {
        return carService.getCars();
    }

    @Value( "${namecar:unknownCar}" )
    private String nameCar;
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CarDto create(@Valid @RequestBody CarDto car) {
        car.name = car.name + " " + nameCar;
        return carService.createCar(car);
    }
}
