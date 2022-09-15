package com.github.allanccruz;

import com.github.allanccruz.api.dto.CarDTO;
import com.github.allanccruz.api.exceptions.ObjectNotFoundException;
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

        CarDTO carDTO = carService.saveCar(car);
        assertNotNull(carDTO);

        Long id = carDTO.getId();
        assertNotNull(id);

        //Buscar o objeto no db
        carDTO = carService.getCarById(id);
        assertNotNull(carDTO);

        assertEquals("Car Test", car.getName());
        assertEquals("test", car.getType());

        //Deletar o objeto do db
        carService.deleteCarById(id);

        //Verificar se deletou
        try {
            assertNull(carService.getCarById(id));
            fail("Car not excluded");
        } catch (ObjectNotFoundException e) {
            //OK
        }
    }

    @Test
    public void testingGetAllCars() {
        List<CarDTO> cars = carService.getCars();
        assertEquals(6, cars.size());
    }

    @Test
    public void testingGetOneCar() {
        CarDTO car = carService.getCarById(4L);
        assertNotNull(car);
        assertEquals("AUDI GT Spyder", car.getName());
    }

    @Test
    public void testingGetCarsByType() {
        assertEquals(2, carService.getCarsByType("esportivos").size());
        assertEquals(2, carService.getCarsByType("luxo").size());
        assertEquals(2, carService.getCarsByType("classicos").size());
        assertEquals(0, carService.getCarsByType("voadores").size());
    }
}
