package com.github.allanccruz.api.controller;

import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Iterable<Car> getCars() {
        return carService.getFakeCars();
    }
}
