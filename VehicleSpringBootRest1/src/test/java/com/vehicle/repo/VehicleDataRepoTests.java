package com.vehicle.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.vehicle.model.VehicleData;

@DataJpaTest
public class VehicleDataRepoTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private VehicleDataRepo repo;

	// Saving Data
	@Test
	public void saveVehicleData() {
		// Assigning data to be stored in database
		VehicleData data = saveData();// from saveDataMehod

		// Saving Data in DB
		VehicleData datainDB = entityManager.persist(data);
		assertNotNull(datainDB);

		// Fetching data From DB
		VehicleData dataFromDB = repo.getOne(datainDB.getDealer_id());

		// Comparing Both Data in DB and Data From DB
		assertThat(dataFromDB).isEqualTo(datainDB);

	}

	// Test for fetching data as a list from database
	@Test
	public void testGetData() {

		// Assigning data to be Stored in database
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		// Saving data in database
		VehicleData saveddata = entityManager.persist(data);

		// Adding to list of data from database
		List<VehicleData> list = new ArrayList<>();
		list.add(saveddata);

		// Fetching data from database
		List<VehicleData> FromDB = repo.findAll();

		// Testing list from database and list in database
		assertThat(FromDB).isEqualTo(list);
	}

	// Test for fetching data as a list from database by make
	@Test
	public void testFindByMake() {

		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		// data in database
		VehicleData saveinDb = entityManager.persist(data);
		List<VehicleData> list = new ArrayList<>();
		list.add(saveinDb);

		// data from database by make
		List<VehicleData> dataFromDb = repo.findByMake("Maruti");

		// comparing data in and data from Db by finding by make property
		assertThat(dataFromDb).isEqualTo(list);
	}

	// Test for fetching data as a list from database by model
	@Test
	public void testFindByModel() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		// data in database
		VehicleData saveinDb = entityManager.persist(data);
		List<VehicleData> list = new ArrayList<>();
		list.add(saveinDb);

		// data from database by model
		List<VehicleData> dataFromDb = repo.findByModel("Swift");

		// comparing data in and data from DB by finding by model property
		assertThat(dataFromDb).isEqualTo(list);
	}
	// Test for fetching data as a list from database by year
	@Test
	public void testFindByYear() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		// data in database
		VehicleData saveinDb = entityManager.persist(data);
		List<VehicleData> list = new ArrayList<>();
		list.add(saveinDb);

		// data from database by year
		List<VehicleData> dataFromDb = repo.findByYear(2020);

		// comparing data in and data from DB by finding by year property
		assertThat(dataFromDb).isEqualTo(list);
	}

	// Test for fetching data as a list from database by color
	@Test
	public void testFindByColor() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		// data in database
		VehicleData saveinDb = entityManager.persist(data);
		List<VehicleData> list = new ArrayList<>();
		list.add(saveinDb);

		// data from database by color
		List<VehicleData> dataFromDb = repo.findByColor("Red");

		// comparing data in and data from DB by finding by color property
		assertThat(dataFromDb).isEqualTo(list);
	}

	// method creating object state to store in database and this method is used in testSaveVehicleData
	//we can also use this method  in all test cases to store object state into DB
	private VehicleData saveData() {

		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		return data;
	}

}
