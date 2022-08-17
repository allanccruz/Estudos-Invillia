package com.api.parkingcontrol.service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ParkingSpotService {

     final ParkingSpotRepository parkingSpotRepository;

     public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
         this.parkingSpotRepository = parkingSpotRepository;
     }

     @Transactional //Anotação para que métodos construtivos ou destrutivos garantam um rollback no DB caso algo dê errado
    public ParkingSpotModel save (ParkingSpotModel parkingSpotModel) {
         return parkingSpotRepository.save(parkingSpotModel);
    }
}
