package com.mtzperez.springidea.controller;

import com.mtzperez.springidea.model.Car;
import com.mtzperez.springidea.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("cars")
@Profile("dev")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAll() {
        return carService.getCars();
    }

    @GetMapping("/test")
    public @ResponseBody
    ResponseEntity customEndPoint(){
        return  new ResponseEntity<>("REST end point", HttpStatus.OK);
    }

    @Value( "${nameCar:coche}" )
    private String nameCar;
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car create(@Valid @RequestBody Car car) {
        car.name = nameCar;
        return carService.createCar(car);
    }
}
