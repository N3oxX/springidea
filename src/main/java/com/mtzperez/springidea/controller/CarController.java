package com.mtzperez.springidea.controller;

import com.mtzperez.springidea.model.Car;
import com.mtzperez.springidea.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.getCars();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car create(@Valid @RequestBody Car car) {
        return carService.createCar(car);
    }
}
