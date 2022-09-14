package com.github.allanccruz;

import com.github.allanccruz.api.dto.CarDTO;
import com.github.allanccruz.domain.entities.Car;
import com.github.allanccruz.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarsAPITest {
    @Autowired
    protected TestRestTemplate rest;

    @Autowired
    private CarService carService;

    private ResponseEntity<CarDTO> getCar(String url) {
        return rest.withBasicAuth("user", "123").getForEntity(url, CarDTO.class);
    }

    private ResponseEntity<List<CarDTO>> getCars(String url) {
        return rest.withBasicAuth("user", "123").exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CarDTO>>() {
                });
    }


    @Test
    public void testSave() {

        Car car = new Car();
        car.setName("Porshe");
        car.setType("esportivos");

        // Insert
        ResponseEntity response = rest.withBasicAuth("admin", "123").postForEntity("/api/v1/cars", car, null);
        System.out.println(response);

        // Verifica se criou
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        // Buscar o objeto
        String location = response.getHeaders().get("location").get(0);
        CarDTO c = getCar(location).getBody();

        assertNotNull(c);
        assertEquals("Porshe", c.getName());
        assertEquals("esportivos", c.getType());

        // Deletar o objeto
        rest.withBasicAuth("user", "123").delete(location);

        // Verificar se deletou
        assertEquals(HttpStatus.NOT_FOUND, getCar(location).getStatusCode());
    }

    @Test
    public void testGetAllCars() {
        List<CarDTO> cars = getCars("/api/v1/cars").getBody();
        assertNotNull(cars);
        assertEquals(6, cars.size());
    }

    @Test
    public void testGetCarsByType() {

        assertEquals(2, getCars("/api/v1/cars/tipo/classicos").getBody().size());
        assertEquals(2, getCars("/api/v1/cars/tipo/esportivos").getBody().size());
        assertEquals(2, getCars("/api/v1/cars/tipo/luxo").getBody().size());

        assertEquals(HttpStatus.NO_CONTENT, getCars("/api/v1/cars/tipo/xxx").getStatusCode());
    }

    @Test
    public void testGetOk() {

        ResponseEntity<CarDTO> response = getCar("/api/v1/cars/4");
        assertEquals(response.getStatusCode(), HttpStatus.OK);

        CarDTO c = response.getBody();
        assertEquals("AUDI GT Spyder", c.getName());
    }

    @Test
    public void testGetNotFound() {

        ResponseEntity response = getCar("/api/v1/cars/1100");
        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}