package com.mtzperez.springidea.service;

import com.mtzperez.springidea.model.dto.CarDto;
import com.mtzperez.springidea.model.entity.Car;
import com.mtzperez.springidea.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> getCars() {
        return carRepository.findAll().stream().map(car -> new CarDto(car.name)).collect(Collectors.toList());
    }

    public CarDto createCar(CarDto carDto) {
       Car car = new Car(carDto.name);
       carRepository.save(car);
       return new CarDto(car.name);
    }


}
