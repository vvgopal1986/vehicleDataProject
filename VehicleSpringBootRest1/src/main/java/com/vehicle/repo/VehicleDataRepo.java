package com.vehicle.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.model.VehicleData;

@Repository
public interface VehicleDataRepo extends JpaRepository<VehicleData, Integer> {
	
	
	

	//Customized methods for retrieving Vehicle Listings
	
	 List<VehicleData>findByMake(String make);
	 List<VehicleData>findByModel(String model);
	 List<VehicleData>findByYear(int year);
	 List<VehicleData>findByColor(String color);
 

	 		
	
		
 
	 
}
