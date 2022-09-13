package com.github.allanccruz.api.dto;

import com.github.allanccruz.domain.entities.Car;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CarDTO {
    private Long id;
    private String name;
    private String type;

    public static CarDTO create (Car car) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(car, CarDTO.class);
    }
}
