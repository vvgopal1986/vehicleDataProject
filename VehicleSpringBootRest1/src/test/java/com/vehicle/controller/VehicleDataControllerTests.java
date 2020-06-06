package com.vehicle.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vehicle.model.VehicleData;
import com.vehicle.service.VehicleService;

@WebMvcTest
class VehicleDataControllerTests{
 
@Autowired
private MockMvc mockmvc;
	
	@MockBean
	private VehicleService service;
	
 //TEST FOR CREATING DATA USING SPECIFIC URI 
	@Test
	public void testSetData() throws Exception {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		//Making input as a JsON Format
		String inputJson=this.mapToJson(data);
		String URI="/vehicle_listings/102";
		
		//saving data by service class method
		Mockito.when(service.setDataList(Mockito.any(VehicleData.class))).thenReturn(data);
		
		//building requests such as request method, accepting media types
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON)
				.content(inputJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		//processing requests and returning result
		MvcResult result=mockmvc.perform(requestBuilder).andReturn();
		//getting response as output
		MockHttpServletResponse response=result.getResponse();
		 
		//converting the output to JSON format
		String outputJson=response.getContentAsString();
		
	//comparing outputJson and InputJson 
	 assertThat(outputJson).isEqualTo(inputJson);
	assertEquals(HttpStatus.OK.value(), response.getStatus());	
	
	}
	
	
	/*TESTS FOr DATA RETRIEVING BY SPECIFIED URI'S  AND GETTING RESPONSE ACCORDING TO THE SPECIFIED URIS*/
	
	
	/*test to fetch the entire list of VehicleData I.E when user calls 
	 * /search 
	URI then is able to find and fetch  all the vehicle data list */
	@Test
	public void testGetList() throws Exception {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		VehicleData data1 = new VehicleData();
		data1.setDealer_id(103);
		data1.setCode("Mar");
		data1.setMake("Maruti");
		data1.setModel("Swift");
		data1.setkW(150);
		data1.setColor("Red");
		data1.setYear(2020);
		data1.setPrice(250000);
		//add objectState into List Object to get data as a list
		List<VehicleData> dataList=new ArrayList<VehicleData>();
		dataList.add(data);
		dataList.add(data1);
		//converting to JSON format
		String expectedJson=this.mapToJson(dataList);
		String URI="/search";
		//calling service method and returning dataList
		Mockito.when(service.getDataList()).thenReturn(dataList);
		//request methods and accepting format
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockmvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		String output=response.getContentAsString();
		
		assertThat(output).isEqualTo(expectedJson);
		
				 
		
	}
	//test to get List  searching by Model
	@Test
	public void testGetListModel() throws Exception {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		VehicleData data1 = new VehicleData();
		data1.setDealer_id(103);
		data1.setCode("Mar");
		data1.setMake("Maruti");
		data1.setModel("Swift");
		data1.setkW(150);
		data1.setColor("Blue");
		data1.setYear(2020);
		data1.setPrice(250000);
		
		//adding  objectState into List Object to get data as a list
		List<VehicleData> dataList=new ArrayList<VehicleData>();
		dataList.add(data);
		dataList.add(data1);
		
		//converting to JSON format
		String expectedJson=this.mapToJson(dataList);
		String URI="/search/model/Swift";
		
		//calling service method and returning dataList
		Mockito.when(service.getDataListModel(Mockito.anyString())).thenReturn(dataList);
		
		//request methods and accepting format
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		//getting result and the returning the result data
		MvcResult result=mockmvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		//getting content with the help of response object
		String output=response.getContentAsString();
		//comparing the results of both expected and actual valuea;
		assertThat(output).isEqualTo(expectedJson);
		
				 
		
	}
	
	
	//test to get List by make
	@Test
	public void testGetListMake() throws Exception {
		VehicleData data = new VehicleData();
		data.setDealer_id(102);
		data.setCode("Mar");
		data.setMake("Maruti");
		data.setModel("Swift");
		data.setkW(150);
		data.setColor("Red");
		data.setYear(2020);
		data.setPrice(250000);
		VehicleData data1 = new VehicleData();
		data1.setDealer_id(103);
		data1.setCode("Mar");
		data1.setMake("Maruti");
		data1.setModel("Swift");
		data1.setkW(150);
		data1.setColor("Blue");
		data1.setYear(2020);
		data1.setPrice(250000);
		
		//add objectState into List Object to get data as a list
		List<VehicleData> dataList=new ArrayList<VehicleData>();
		dataList.add(data);
		dataList.add(data1);
		
		//converting to JSON format
		String expectedJson=this.mapToJson(dataList);
		String URI="/search/make/Maruti";
		
		//calling service method and returning dataList
		Mockito.when(service.getDataList(Mockito.anyString())).thenReturn(dataList);
		
		//request methods and accepting format
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result=mockmvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		
		String output=response.getContentAsString();
		
		assertThat(output).isEqualTo(expectedJson);
		
				 
		
	}
	
	//test to get List by year
		@Test
		public void testGetListYear() throws Exception {
			VehicleData data = new VehicleData();
			data.setDealer_id(102);
			data.setCode("Mar");
			data.setMake("Maruti");
			data.setModel("Swift");
			data.setkW(150);
			data.setColor("Red");
			data.setYear(2020);
			data.setPrice(250000);
			VehicleData data1 = new VehicleData();
			data1.setDealer_id(103);
			data1.setCode("Mar");
			data1.setMake("Maruti");
			data1.setModel("Swift");
			data1.setkW(150);
			data1.setColor("Blue");
			data1.setYear(2020);
			data1.setPrice(250000);
			
			//add objectState into List Object to get data as a list
			List<VehicleData> dataList=new ArrayList<VehicleData>();
			dataList.add(data);
			dataList.add(data1);
			
			//converting to JSON format
			String expectedJson=this.mapToJson(dataList);
			String URI="/search/year/2020";
			
			//calling service method and returning dataList
			Mockito.when(service.getDataListYear(Mockito.anyInt())).thenReturn(dataList);
			
			//request methods and accepting format
			RequestBuilder requestBuilder=MockMvcRequestBuilders
					.get(URI)
					.accept(MediaType.APPLICATION_JSON);
			
			MvcResult result=mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response=result.getResponse();
			
			String output=response.getContentAsString();
			
			assertThat(output).isEqualTo(expectedJson);
			
					 
			
		}
	
		//test to get List by color
		@Test
		public void testGetListColor() throws Exception {
			VehicleData data = new VehicleData();
			data.setDealer_id(102);
			data.setCode("Mar");
			data.setMake("Maruti");
			data.setModel("Swift");
			data.setkW(150);
			data.setColor("Red");
			data.setYear(2020);
			data.setPrice(250000);
			VehicleData data1 = new VehicleData();
			data1.setDealer_id(103);
			data1.setCode("Mar");
			data1.setMake("Maruti");
			data1.setModel("Swift");
			data1.setkW(150);
			data1.setColor("Blue");
			data1.setYear(2020);
			data1.setPrice(250000);
			
			//add objectState into List Object to get data as a list
			List<VehicleData> dataList=new ArrayList<VehicleData>();
			dataList.add(data);
			dataList.add(data1);
			
			//converting to JSON format
			String expectedJson=this.mapToJson(dataList);
			String URI="/search/color/red";
			
			//calling service method and returning dataList
			Mockito.when(service.getDataListColor(Mockito.anyString())).thenReturn(dataList);
			
			//request methods and accepting format
			RequestBuilder requestBuilder=MockMvcRequestBuilders
					.get(URI)
					.accept(MediaType.APPLICATION_JSON);
			
			MvcResult result=mockmvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response=result.getResponse();
			
			String output=response.getContentAsString();
			
			assertThat(output).isEqualTo(expectedJson);
			
					 
			
		}
	
	/**
	 * 
	 This  utility method Maps an object into a JSON string using Jackson ObjectMapper
	  */
	
	
private String mapToJson(Object object)throws JsonProcessingException{
		
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(object);
		
	}

}
