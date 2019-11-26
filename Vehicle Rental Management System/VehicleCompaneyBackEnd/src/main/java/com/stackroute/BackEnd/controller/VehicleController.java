package com.stackroute.BackEnd.controller;

import com.stackroute.BackEnd.domain.Vehicle;
import com.stackroute.BackEnd.exception.VehicleAlreadyExistsException;
import com.stackroute.BackEnd.exception.VehicleNotFoundException;
import com.stackroute.BackEnd.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class VehicleController<VehicleDao> {

    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {

        this.vehicleService = vehicleService;
    }

    @PostMapping("vehicle")
    public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle) throws VehicleAlreadyExistsException {
        ResponseEntity responseEntity;
        //try {
        vehicleService.saveVehicle(vehicle);
        responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        //}
        //catch (Exception ex){
        //  responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }

    @GetMapping("vehicle")
    public ResponseEntity<?> getVehicles() {
        ResponseEntity responseEntity;
        List<Vehicle> vehicles = vehicleService.getVehicles();
        //try{
        responseEntity = new ResponseEntity<>(vehicles, HttpStatus.OK);
        //}catch (Exception ex) {
        //  responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }

    @GetMapping("vehicle/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable int id) throws VehicleNotFoundException {
        ResponseEntity responseEntity;
        // try{
        responseEntity = new ResponseEntity<Optional<Vehicle>>(vehicleService.getVehicleById(id), HttpStatus.CREATED);
        //}catch (TrackNotFoundException ex) {
        //responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }

    @GetMapping("vehicle/vehicleNumber")
    public ResponseEntity<?> getVehicleByVehicleNumber(@PathVariable(value = "vehicleNumber") String vehicleNumber) throws VehicleNotFoundException {
        ResponseEntity responseEntity;
        // try{
        vehicleService.getVehicleByVehicleNumber(vehicleNumber);
        responseEntity = new ResponseEntity<List<Vehicle>>(vehicleService.getVehicleByVehicleNumber(vehicleNumber), HttpStatus.OK);
        // }catch (TrackNotFoundException ex) {
        //   responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }


    // @PutMapping("vehicle/{id}")
    // public  ResponseEntity<?> updateVehicles(@PathVariable(value = "id") int id,@Valid @RequestBody Vehicle vehicle) throws VehicleNotFoundException, VehicleAlreadyExistsException {
    //   ResponseEntity responseEntity;
    // Optional<Vehicle> vehicle1 = vehicleService.getVehicleById(id);
    // try{
    //if(!vehicle1.isPresent()){
    //  throw new Exception("id-"+id);
    // }
    //   vehicle.setVehicleId(id);
    // vehicleService.saveVehicle(vehicle);
    // responseEntity = new ResponseEntity(vehicleService.getVehicles(), HttpStatus.CREATED);
    //}catch (Exception ex) {
    // responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
    //  }
    //  return responseEntity;
    // }

    @DeleteMapping("vehicle/{id}")
    public ResponseEntity<?> deleteVehicles(@PathVariable("id") int id) {
        ResponseEntity responseEntity;
        //try{
        vehicleService.deleteVehicle(id);
        responseEntity = new ResponseEntity(vehicleService.getVehicles(), HttpStatus.CREATED);
        //}catch (Exception ex) {
        //  responseEntity = new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        //}
        return responseEntity;
    }
}

