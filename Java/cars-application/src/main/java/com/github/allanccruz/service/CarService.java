package com.github.allanccruz.service;

import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.domain.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<Car> getCars () {
        return carRepository.findAll();
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> getFakeCars () {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1L, "Fusca"));
        cars.add(new Car(2L, "Brasilia"));
        cars.add(new Car(3L, "Kombi"));

        return cars;
    }


}
