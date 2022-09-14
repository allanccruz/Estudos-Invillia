package com.github.allanccruz.api.controller;

import com.github.allanccruz.api.dto.CarDTO;
import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.service.CarService;
import org.hibernate.dialect.H2Dialect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CarDTO>> getCars() {
        return ResponseEntity.ok(carService.getCars());
        //return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCarById(@PathVariable Long id) { //Pra passar o parãmetro na URL
        Optional<CarDTO> carExists = carService.getCarById(id);

        return carExists.map(c -> ResponseEntity.ok(c))
                .orElse(ResponseEntity.notFound().build());

//        return carExists.isPresent() ? ResponseEntity.ok(carExists.get()) : ResponseEntity.notFound().build();

//        if (carExists.isPresent()) {
//            return ResponseEntity.ok(carExists.get());
//        }
//        else {
//            return ResponseEntity.notFound().build();
//        }

    }

    @GetMapping("/tipo/{type}")
    public ResponseEntity<List<CarDTO>> getCarsByType(@PathVariable String type) { //Pra passar o parãmetro na URL
        List<CarDTO> cars = carService.getCarsByType(type);

        return cars.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity postCar(@RequestBody Car car) {
        try {
            carService.saveCar(car);
            return ResponseEntity.created(null).build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCarById(@PathVariable("id") Long id, @RequestBody Car car) {
        car.setId(id);
        CarDTO carDTO = carService.updateCarById(id, car);
        return carDTO != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarById(@PathVariable("id") Long id) {
        Optional<CarDTO> carExists = carService.getCarById(id);
        if(carExists.isPresent()) {
            carService.deleteCarById(id);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
