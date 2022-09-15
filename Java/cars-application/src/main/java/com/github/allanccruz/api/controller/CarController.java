package com.github.allanccruz.api.controller;

import com.github.allanccruz.api.dto.CarDTO;
import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        CarDTO carExists = carService.getCarById(id);

        return ResponseEntity.ok(carExists);
    }

    @GetMapping("/tipo/{type}")
    public ResponseEntity<List<CarDTO>> getCarsByType(@PathVariable String type) { //Pra passar o parãmetro na URL
        List<CarDTO> cars = carService.getCarsByType(type);
        return cars.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity postCar(@RequestBody Car car) {
            carService.saveCar(car);
            URI location = getUri(car.getId());
            return ResponseEntity.created(location).build();
    }

    //Monta a URL do novo objeto criado e retorna ela no header da requisição
    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCarById(@PathVariable("id") Long id, @RequestBody Car car) {
        car.setId(id);
        CarDTO carDTO = carService.updateCarById(id, car);
        return carDTO != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarById(@PathVariable("id") Long id) {
            carService.deleteCarById(id);
            return ResponseEntity.ok().build();
    }
}