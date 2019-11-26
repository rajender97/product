package com.stackroute.BackEnd.service;

import com.stackroute.BackEnd.domain.Vehicle;
import com.stackroute.BackEnd.exception.VehicleAlreadyExistsException;
import com.stackroute.BackEnd.exception.VehicleNotFoundException;
import com.stackroute.BackEnd.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class VehicleServiceImpl implements VehicleService {


    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) throws VehicleAlreadyExistsException {
        if (vehicleRepository.existsById(vehicle.getId())) {
            throw new VehicleAlreadyExistsException("Vehicle already exists");
        }
        Vehicle vehicle1 = vehicleRepository.save(vehicle);
        if (vehicle1 == null) {
            throw new VehicleAlreadyExistsException("Vehicle is already exists");
        }

        return vehicle1;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle updateComments(Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }

    @Override
    public boolean deleteVehicle(int vehicleId) {
        vehicleRepository.deleteById(vehicleId);
        return true;
    }

    @Override
    public Optional<Vehicle> getVehicleById(int id) throws VehicleNotFoundException {

        if (!vehicleRepository.existsById(id)) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        Vehicle list = vehicleRepository.findById(id).get();
        if (list == null) {
            throw new VehicleNotFoundException("Vehicle not found");
        }
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getVehicleByVehicleNumber(String vehicleNumber) throws VehicleNotFoundException {
        List<Vehicle> list = vehicleRepository.findByVehicleNumber(vehicleNumber);
        if (list.isEmpty()) {
            throw new VehicleNotFoundException("Vehicle not Found");
        }
        return list;
    }
}

