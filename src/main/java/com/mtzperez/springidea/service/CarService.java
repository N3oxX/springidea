package com.mtzperez.springidea.service;

import com.mtzperez.springidea.model.Car;
import com.mtzperez.springidea.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car createCar(Car car) {
       return carRepository.save(car);
    }


}
