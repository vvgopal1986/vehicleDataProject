package com.vehicle.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vehicle.model.VehicleData;
import com.vehicle.repo.VehicleDataRepo;

@Service
public class VehicleService {

	@Autowired
	private VehicleDataRepo repo;

	// service methods

	public VehicleData setDataList(VehicleData data) {

		return repo.save(data);

	}

	public VehicleData setCsvDataList(VehicleData data) {

		return repo.save(data);

	}

	public List<VehicleData> getDataList() {

		return repo.findAll();
	}

	public List<VehicleData> getDataList(String make) {

		return repo.findByMake(make);
	}

	public List<VehicleData> getDataListModel(String model) {

		return repo.findByModel(model);
	}

	public List<VehicleData> getDataListYear(int year) {

		return repo.findByYear(year);

	}

	public List<VehicleData> getDataListColor(String color) {

		return repo.findByColor(color);
	}

} 
