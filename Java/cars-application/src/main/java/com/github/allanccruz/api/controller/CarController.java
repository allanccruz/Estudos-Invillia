package com.github.allanccruz.api.controller;

import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public Iterable<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) { //Pra passar o parãmetro na URL
        return carService.getCarById(id);
    }

    @GetMapping("/tipo/{type}")
    public Iterable<Car> getCarsByType(@PathVariable String type) { //Pra passar o parãmetro na URL
        return carService.getCarsByType(type);
    }
}
