package com.warehouse.data;

import java.util.Map;

public class Package {


	public String entryDate;
	public String expirationDate;
	public ProductModel productDetails;
	
	public Package(){
	}
	
	public Package(String name, String entry, String expiration){
		this.entryDate = entry;
		this.expirationDate = expiration;
		productDetails = new ProductModel(name);
	}	
	public Package(String name, String entry, String expiration, Map<String, String> productAttributes){
		this.entryDate = entry;
		this.expirationDate = expiration;
		productDetails = new ProductModel(name, productAttributes);
	}
	
	public Package(String category, String name, String entry, String expiration,String price, String measure, Map<String, String> productAttributes){
		this.entryDate = entry;
		this.expirationDate = expiration;
		productDetails = new ProductModel(category, name, price, measure, productAttributes);
	}
	
	
	public Package(String category, String name, String entry, String expiration,String price, String measure){
		this.entryDate = entry;
		this.expirationDate = expiration;
		productDetails = new ProductModel(category, name, price, measure);
	}
	
	public String toString(){
		return "entryDate: " + entryDate + ", expirationDate: " + expirationDate + ", ProductData: " + productDetails;
	}
}
