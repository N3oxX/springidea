package com.mtzperez.springidea.service;

import com.mtzperez.springidea.model.entity.Car;
import com.mtzperez.springidea.model.dto.CarDto;
import com.mtzperez.springidea.repository.CarRepository;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest @RunWith(SpringRunner.class)
public class CarServiceTest {

    @InjectMocks CarService carService;
    @Mock private  CarRepository carRepository;

    @BeforeEach public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllCarsOk(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        Mockito.when(carRepository.findAll()).thenReturn(cars);
        List<CarDto> carDtos = carService.getCars();
        Assert.assertEquals(1, carDtos.size());
    }

    @Test public void createCarOk(){
        String name = "Ferrari";
        Car createdCar = new Car();
        createdCar.setName(name);
        CarDto carInputDto = new CarDto(name);
        Mockito.when(carRepository.save(Mockito.any(Car.class))).thenReturn(createdCar);
        CarDto carOutputDto = carService.createCar(carInputDto);
        Assert.assertEquals(createdCar.getName(), carOutputDto.getName());
    }


}