package com.vehicle.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vehicle.model.VehicleData;
import com.vehicle.repo.VehicleDataRepo;

@SpringBootTest
public class VehicleServiceTests {
	
	@Autowired
	private VehicleService service;
	
	@MockBean
	private VehicleDataRepo repo;

	// test to Save Data
	@Test
	public void testSetDataList() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		// when data saved by save method of VehicledataRepo Class then it returns the
		// saved data
		Mockito.when(repo.save(data)).thenReturn(data);

		// comparing methods
		assertThat(service.setDataList(data)).isEqualTo(data);
	}

	
	// test to getDataList from DB
	@Test
	public void testGetDataList() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);

		// we want to fetch list of data
		List<VehicleData> datalist = new ArrayList<>();
		datalist.add(data);

		Mockito.when(repo.findAll()).thenReturn(datalist);

		// comparing service method and returned data-list if true test is success
		assertThat(service.getDataList()).isEqualTo(datalist);

	}
	@Test 
	public void testGetListByModel() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		// we want to fetch list of data by searching with Model
		List<VehicleData> datalist = new ArrayList<>();
		datalist.add(data);
		// comparing service method and returned data-list if true test is success
	Mockito.when(repo.findByModel("Swift")).thenReturn(datalist);
	assertThat(service.getDataListModel("Swift")).isEqualTo(datalist);

		
	}

	@Test 
	public void testGetListByMake() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		// we want to fetch list of data by searching with Make
		List<VehicleData> datalist = new ArrayList<>();
		datalist.add(data);
		// comparing service method and returned data-list if true test is success
	Mockito.when(repo.findByMake("Maruti")).thenReturn(datalist);
	assertThat(service.getDataList("Maruti")).isEqualTo(datalist);

		
	}
	
	@Test 
	public void testGetListByYear() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		// we want to fetch list of data by searching with Year
		List<VehicleData> datalist = new ArrayList<>();
		datalist.add(data);
		// comparing service method and returned data-list if true test is success
	Mockito.when(repo.findByYear(2020)).thenReturn(datalist);
	assertThat(service.getDataListYear(2020)).isEqualTo(datalist);

		
	}
	@Test 
	public void testGetListByColor() {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		// we want to fetch list of data by searching with Color
		List<VehicleData> datalist = new ArrayList<>();
		datalist.add(data);
		// comparing service method and returned data-list if true test is success
	Mockito.when(repo.findByColor("red")).thenReturn(datalist);
	assertThat(service.getDataListColor("red")).isEqualTo(datalist);

		
	}
}
