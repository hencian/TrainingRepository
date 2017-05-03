package com.warehouse.data;

import java.util.Map;

public class Package {


	public String entryDate;
	public String expirationDate;
	public ProductModel productDetails;

	
	public Package(String category, String name, String entry, String expiration,double unitPrice,double price, double measure, Map<String, String> productAttributes){
		this.entryDate = entry;
		this.expirationDate = expiration;
		productDetails = new ProductModel(category, name,unitPrice, price, measure, productAttributes);
	}
	
	
	public Package(String category, String name, String entry, String expiration,double unitPrice,double price, double measure){
		this.entryDate = entry;
		this.expirationDate = expiration;
		productDetails = new ProductModel(category, name,unitPrice, price, measure);
	}

	public String toString(){
		return "entryDate: " + entryDate + ", expirationDate: " + expirationDate + ", ProductData: " + productDetails;
	}
}
