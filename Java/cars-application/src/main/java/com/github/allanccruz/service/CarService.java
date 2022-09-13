package com.github.allanccruz.service;

import com.github.allanccruz.api.dto.CarDTO;
import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.domain.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarDTO> getCars () {
        return carRepository.findAll().stream().map(c -> CarDTO.create(c)).collect(Collectors.toList());
    }

    public Optional<CarDTO> getCarById(Long id) {
        return carRepository.findById(id).map(c -> CarDTO.create(c));
    }

    public List<CarDTO> getCarsByType(String type) {
        return carRepository.findByType(type).stream().map(c -> CarDTO.create(c)).collect(Collectors.toList());
    }

    public CarDTO saveCar(Car car) {
        return CarDTO.create(carRepository.save(car));
    }

    public CarDTO updateCarById(Long id, Car car) {
        Assert.notNull(id, "Car not found.");

        //Procura o carro no banco de dados
        Optional<Car> carExists = carRepository.findById(id);
        if(carExists.isPresent()) {
            Car db = carExists.get();
            //Copiar as propriedades
            db.setName(car.getName());
            db.setType(car.getType());

            //Atualiza o carro
            carRepository.save(db);

            return CarDTO.create(db);
        }
        else {
            return null;
        }
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}