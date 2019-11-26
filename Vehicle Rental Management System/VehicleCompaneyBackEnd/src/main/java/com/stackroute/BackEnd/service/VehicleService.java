package com.stackroute.BackEnd.service;

import com.stackroute.BackEnd.domain.Vehicle;
import com.stackroute.BackEnd.exception.VehicleAlreadyExistsException;
import com.stackroute.BackEnd.exception.VehicleNotFoundException;
import java.util.List;
import java.util.Optional;

public interface VehicleService {

    public Vehicle saveVehicle(Vehicle vehicle) throws VehicleAlreadyExistsException;

    public List<Vehicle> getVehicles();

    public Vehicle updateComments(Vehicle vehicle);

    public boolean deleteVehicle(int vehicleId);

    public Optional<Vehicle> getVehicleById(int id) throws VehicleNotFoundException;

    public List<Vehicle> getVehicleByVehicleNumber(String vehicleNumber) throws VehicleNotFoundException;

}

