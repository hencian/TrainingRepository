package com.problem;

import java.util.Date;

public class Package {

	public static void main(String[] args) {
	 
		Fruit apple= new Fruit();
		apple.nutritionalQuality=12;
		apple.pricePerUnit=6;
		apple.expirationDate= new Date();
		apple.entryDate= new Date();
		apple.measurableUnit=Units.KG;
		
		Fruit orange =new Fruit();
		orange.entryDate=new Date();
		orange.expirationDate=new Date();
		orange.measurableUnit=Units.BAG;
		orange.nutritionalQuality= 3;
		orange.pricePerUnit=13;
		
		
		Fruit peaches =new Fruit();
		peaches.entryDate=new Date();
		peaches.expirationDate=new Date();
		peaches.measurableUnit=Units.BOX;
		peaches.nutritionalQuality= 4;
		peaches.pricePerUnit=30;
		
		Vegetable potatos= new Vegetable();
		potatos.entryDate=new Date();
		potatos.expirationDate=new Date();
		potatos.measurableUnit=Units.BAG;
		potatos.pricePerUnit=15;
		potatos.producer="chichi";
		
		Vegetable onion= new Vegetable();
		onion.entryDate=new Date();
		onion.expirationDate=new Date();
		onion.measurableUnit=Units.BAG;
		onion.pricePerUnit=2.5;
		onion.producer="chirichi";
		
		Other cracker =new Other();
		cracker.entryDate= new Date();
		cracker.expirationDate=new Date();
		cracker.measurableUnit=Units.PACK;
		cracker.pricePerUnit=2;
	
		

	}
}
