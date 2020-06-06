package com.vehicle.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleData {
	@Id
	private int dealer_id;
	private String code;
	private String make;
	private String model;
	private int kW;
	private int year;
	private String color;
	private int price;

	public int getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(int dealer_id) {
		this.dealer_id = dealer_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getkW() {
		return kW;
	}

	public void setkW(int kW) {
		this.kW = kW;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "VehicleData [dealer_id=" + dealer_id + ", code=" + code + ", make=" + make + ", model=" + model
				+ ", power_in_ps=" + kW + ", year=" + year + ", color=" + color + ", price=" + price + "]";
	}
}
