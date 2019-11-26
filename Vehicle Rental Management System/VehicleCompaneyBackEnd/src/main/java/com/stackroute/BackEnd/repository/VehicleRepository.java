package com.stackroute.BackEnd.repository;

import com.stackroute.BackEnd.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface VehicleRepository extends MongoRepository<Vehicle, Integer> {

    List<Vehicle> findByVehicleNumber(String vehicleNumber);

}
