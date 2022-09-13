package com.github.allanccruz.api.controller;

import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.service.CarService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void postCar(@RequestBody Car car) {
        carService.saveCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCarById(@PathVariable("id") Long id, @RequestBody Car car) {
        return carService.updateCarById(id, car);
    }
}
