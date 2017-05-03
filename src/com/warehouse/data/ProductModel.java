package com.warehouse.data;

import java.util.HashMap;
import java.util.Map;

public class ProductModel {
	public String name;
	public String category;
	public String price;
	public String measure;
	public Map<String, String> attributes = new HashMap<String, String>();

	public ProductModel(String category) {
		this.category = category;
	}

	public ProductModel(String category, Map<String, String> attributes) {
		this.category = category;
		this.attributes = attributes;
	}

	public ProductModel(String category, String name, String price, String measure, Map<String, String> attributes) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.measure = measure;
		this.attributes = attributes;
	}
	

	public ProductModel(String category, String name, String price, String measure) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.measure = measure;
	}

	public String toString() {
		return "Name: "+name+ ", category: " + category + ", price: " + price + ", measure: " + measure + ", Attributes: " + attributes;
	}
}
