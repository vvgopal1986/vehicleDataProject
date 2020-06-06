package com.vehicle.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vehicle.model.VehicleData;
import com.vehicle.service.VehicleService;

@RestController
public class VehicleDataController {
	@Autowired
	private VehicleService service;
 
	// Save methods
	@PostMapping(path = "/upload_csv/{dealer_id}", consumes = { "text/css" })
	public ResponseEntity<VehicleData> setListBycsv(@PathVariable("dealer_id") int dealer_id,
			@RequestBody VehicleData data) {
		data.setDealer_id(dealer_id);
		data = service.setDataList(data);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PostMapping(path = "/vehicle_listings/{dealer_id}")

	public ResponseEntity<VehicleData> setListByjson(@PathVariable("dealer_id") int dealer_id,
			@RequestBody VehicleData data) {

		data.setDealer_id(dealer_id);
		data = service.setDataList(data);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	// Update Methods
	@PutMapping(path = "/upload_csv/{dealer_id}", consumes = { "text/css" })
	public ResponseEntity<VehicleData> setUpdatedListBycsv(@PathVariable("dealer_id") int dealer_id,
			@RequestBody VehicleData data)  {
		data.setDealer_id(dealer_id);
		data = service.setDataList(data);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	@PutMapping(path = "/vehicle_listings/{dealer_id}")
	public ResponseEntity<VehicleData> setUpdatedListByjson(@PathVariable("dealer_id") int dealer_id,
			@RequestBody VehicleData data) {
		data.setDealer_id(dealer_id);
		data = service.setDataList(data);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	// Retrieving Methods

	@GetMapping(path = "/search")
	public List<VehicleData> getList() {

		return service.getDataList();

	}

	@GetMapping(path = "/search/make/{make}")
	public List<VehicleData> getList(@PathVariable("make") String make) {

		return service.getDataList(make);

	}

	@GetMapping(path = "/search/model/{model}")
	public List<VehicleData> getListModel(@PathVariable("model") String model) {

		return service.getDataListModel(model);

	}

	@GetMapping(path = "/search/year/{year}")
	public List<VehicleData> getListYear(@PathVariable("year") int year) {

		return service.getDataListYear(year);

	}

	@GetMapping(path = "/search/color/{color}")
	public List<VehicleData> getListColor(@PathVariable("color") String color) {

		return service.getDataListColor(color);

	}

}
