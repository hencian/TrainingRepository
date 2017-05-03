package com.warehouse.data;

import java.util.HashMap;
import java.util.Map;

public class ProductModel {
	public String name;
	public String category;
	public double price;
	public double measure;
	public double unitPrice;
	public Map<String, String> attributes = new HashMap<String, String>();


	public ProductModel(String category, String name,double unitPrice, double price, double measure, Map<String, String> attributes) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.measure = measure;
		this.attributes = attributes;
		this.unitPrice = unitPrice;
	}
	

	public ProductModel(String category, String name,double unitPrice, double price, double measure) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.measure = measure;
		this.unitPrice = unitPrice;
	}

	public String toString() {
		return "Name: "+name+ ", category: " + category + ", unitPrice:" + unitPrice + ", packagePrice: " + price + ", measure: " + measure + ", Attributes: " + attributes;
	}
}
