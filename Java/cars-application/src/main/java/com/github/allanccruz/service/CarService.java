package com.github.allanccruz.service;

import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.domain.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    public Iterable<Car> getCarsByType(String type) {
        return carRepository.findByType(type);
    }

    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCarById(Long id, Car car) {
        Assert.notNull(id, "Car not found.");

        //Procura o carro no banco de dados
        Optional<Car> existCar = getCarById(id);
        if(existCar.isPresent()) {
            Car db = existCar.get();
            //Copiar as propriedades
            db.setName(car.getName());
            db.setType(car.getType());

            //Atualiza o carro
            carRepository.save(db);

            return db;
        }
        else {
            throw new RuntimeException("Car not found.");
        }
    }
}
