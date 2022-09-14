package com.github.allanccruz;

import com.github.allanccruz.api.dto.CarDTO;
import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarsServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void testingSaveCarOnDb() {
        Car car = new Car();
        car.setName("Car Test");
        car.setType("test");

        CarDTO carDTo = carService.saveCar(car);
        assertNotNull(carDTo);

        Long id = carDTo.getId();
        assertNotNull(id);

        //Buscar o objeto no db
        Optional<CarDTO> op = carService.getCarById(id);
        assertTrue(op.isPresent());

        carDTo = op.get();
        assertEquals("Car Test", carDTo.getName());
        assertEquals("test", carDTo.getType());

        //Deletar o objeto do db
        carService.deleteCarById(id);

        //Verificar se deletou
        assertFalse(carService.getCarById(id).isPresent());
    }

    @Test
    public void testingGetAllCars() {
        List<CarDTO> cars = carService.getCars();
        assertEquals(6, cars.size());
    }

    @Test
    public void testingGetOneCar() {
        Optional<CarDTO> car = carService.getCarById(4L);
        assertTrue(car.isPresent());

        CarDTO c = car.get();
        assertEquals("AUDI GT Spyder", c.getName());
    }

    @Test
    public void testingGetCarsByType() {
        assertEquals(2, carService.getCarsByType("esportivos").size());
        assertEquals(2, carService.getCarsByType("luxo").size());
        assertEquals(2, carService.getCarsByType("classicos").size());
        assertEquals(0, carService.getCarsByType("voadores").size());
    }
}
