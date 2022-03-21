package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class RestaurantEntity {
	@Id
	@Column(name="restaurant_code")
	private String restuarantCode;
	@Column(name="restaurant_name")
	private String restaurantName;
	@Column(name="city")
	private String city;
	@Column(name="address")
	private String address;
	public String getRestuarantCode() {
		return restuarantCode;
	}
	public void setRestuarantCode(String restuarantCode) {
		this.restuarantCode = restuarantCode;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
