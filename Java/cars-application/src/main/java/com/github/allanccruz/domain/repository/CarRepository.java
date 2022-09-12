package com.github.allanccruz.domain.repository;

import com.github.allanccruz.domain.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository <Car, Long> {

}
