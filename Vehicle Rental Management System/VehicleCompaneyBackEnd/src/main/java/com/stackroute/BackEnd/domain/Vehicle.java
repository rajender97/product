package com.stackroute.BackEnd.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
        @Id
        int id;
        String vehicleNumber;
        String driverName;
        String vehicleType;
        String capacity;
        String costPerSlot;
        String vehicleStatus;

}

