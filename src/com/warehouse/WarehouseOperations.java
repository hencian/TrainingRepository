package com.warehouse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import static java.time.temporal.ChronoUnit.DAYS;
import java.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;


import com.warehouse.data.Package;
import com.warehouse.data.SummaryDataModel;
import com.warehouse.data.SummaryProducModel;

public class WarehouseOperations {


	public static LocalDate randomEntryDateGeneration(){
		Random generate = new Random();
		LocalDate currentDate = LocalDate.now();
		LocalDate entryDate = LocalDate.now().minusMonths(6);


		int days = (int) DAYS.between(entryDate,currentDate );





		LocalDate randomEntryDate = entryDate.plusDays(generate.nextInt(days));
		return randomEntryDate;
	}


	public static String calculateExpirationDate(LocalDate entryDate) throws ParseException{

		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");



		LocalDate expiration = entryDate.plusMonths(6);
		return expiration.format(df).toString();

	}

	public static Package randomPackageGenerator() {


		Package result = null;
		Map<String, String> fruitAttributes = new HashMap<String, String>();
		fruitAttributes.put("nutrition", "10");

		Map<String, String> vegetablesAttributes = new HashMap<String, String>();
		vegetablesAttributes.put("nutrition", "10");
		vegetablesAttributes.put("produces", "Cluj");

		int rand = new Random().nextInt(6);

		if (rand == 0) {
			int appleUnit = (new Random().nextInt(250 - 50) + 50);
			result = new Package("fruits", "apple", "10.05.2017", "10.05.2017",6, (6 * appleUnit) , appleUnit, fruitAttributes);
		}
		if (rand == 1) {
			int potatosUnit = (new Random().nextInt(25 - 15) + 15);
			result = new Package("vegetables", "potatoes", "10.10.2017", "07.05.2017",15, (15 * potatosUnit), potatosUnit,
					vegetablesAttributes);
		}
		if (rand == 2) {
			int onionsUnit = (new Random().nextInt(25 - 15) + 15);
			result = new Package("vegetables", "onions", "10.10.17", "28.05.2017",2.5, (2.5 * onionsUnit), onionsUnit,
					vegetablesAttributes);
		}
		if (rand == 3) {
			int orangeUnit = (new Random().nextInt(25 - 15) + 15);
			result = new Package("fruits", "orange", "10.02.17", "29.05.2017",13, (13 * orangeUnit), orangeUnit, fruitAttributes);
		}
		if (rand == 4) {
			int peachesUnit = (new Random().nextInt(60 - 30) + 30);
			result = new Package("fruits", "peaches", "10.01.17", "27.06.2019",30, (30 * peachesUnit), peachesUnit, fruitAttributes);
		}
		if (rand == 5) {
			int crackerUnit = (new Random().nextInt(10));
			result = new Package("others", "cracker", "10.10.17", "01.01.2017",2, (2 * crackerUnit),crackerUnit);

		}
		return result;
	}

	public static SummaryDataModel generateSummary(List<Package> warehouseList) throws ParseException {

		SummaryDataModel result = new SummaryDataModel();


		for (Package packageNow : warehouseList) {
			if (packageNow.productDetails.category.toLowerCase().trim().contentEquals("fruits")) {
				SummaryProducModel fruitItem = new SummaryProducModel();

				if (packageNow.productDetails.name.toLowerCase().trim().contentEquals("apple")) {
					fruitItem.producUnitTotal = (packageNow.productDetails.measure);
					fruitItem.productName = packageNow.productDetails.name;
					fruitItem.producUnitPrice = (packageNow.productDetails.unitPrice);
					fruitItem.productUnit = (packageNow.productDetails.measure);
					fruitItem.productDiscout = calculateDiscount((packageNow.expirationDate),"fruits");
					fruitItem.producTotalPrice = applyDiscount(packageNow.productDetails.price, fruitItem.productDiscout);
					fruitItem.productDiscoutValue = (packageNow.productDetails.price - fruitItem.producTotalPrice);


				}
				if (packageNow.productDetails.name.toLowerCase().trim().contentEquals("peaches")) {
					fruitItem.producUnitTotal = (packageNow.productDetails.measure) * 6;
					fruitItem.productName = packageNow.productDetails.name;
					fruitItem.producUnitPrice = (packageNow.productDetails.unitPrice);
					fruitItem.productUnit = (packageNow.productDetails.measure);
					fruitItem.productDiscout = calculateDiscount((packageNow.expirationDate),"fruits");
					fruitItem.producTotalPrice = applyDiscount(packageNow.productDetails.price, fruitItem.productDiscout);
					fruitItem.productDiscoutValue = (packageNow.productDetails.price - fruitItem.producTotalPrice);
				}
				if (packageNow.productDetails.name.toLowerCase().trim().contentEquals("orange")) {
					fruitItem.producUnitTotal = (packageNow.productDetails.measure) * 2.5;
					fruitItem.productName = packageNow.productDetails.name;
					fruitItem.producUnitPrice = (packageNow.productDetails.unitPrice);
					fruitItem.productUnit = (packageNow.productDetails.measure);
					fruitItem.productDiscout = calculateDiscount((packageNow.expirationDate),"fruits");
					fruitItem.producTotalPrice = applyDiscount(packageNow.productDetails.price, fruitItem.productDiscout);
					fruitItem.productDiscoutValue = (packageNow.productDetails.price - fruitItem.producTotalPrice);
				}

				result.fruitTotalQty += (fruitItem.producUnitTotal);
				result.fruitTotalPrice += (fruitItem.producTotalPrice);
				result.fruitslist.add(fruitItem);
			}

			if (packageNow.productDetails.category.toLowerCase().trim().contentEquals("vegetables")) {
				SummaryProducModel vegetaItem = new SummaryProducModel();
				if (packageNow.productDetails.name.toLowerCase().trim().contentEquals("potatoes")) {
					vegetaItem.producUnitTotal = (packageNow.productDetails.measure) * 10;
					vegetaItem.productName = packageNow.productDetails.name;
					vegetaItem.producUnitPrice = (packageNow.productDetails.unitPrice);
					vegetaItem.productUnit = (packageNow.productDetails.measure);
					vegetaItem.productDiscout = calculateDiscount((packageNow.expirationDate),"vegetables");
					vegetaItem.producTotalPrice = applyDiscount(packageNow.productDetails.price, vegetaItem.productDiscout);
					vegetaItem.productDiscoutValue = (packageNow.productDetails.price - vegetaItem.producTotalPrice);

				}
				if (packageNow.productDetails.category.toLowerCase().trim().contentEquals("vegetables")) {
					if (packageNow.productDetails.name.toLowerCase().trim().contentEquals("onions")) {
						vegetaItem.producUnitTotal = (packageNow.productDetails.measure) * 4;
						vegetaItem.productName = packageNow.productDetails.name;
						vegetaItem.producUnitPrice = (packageNow.productDetails.unitPrice);
						vegetaItem.productUnit = (packageNow.productDetails.measure);
						vegetaItem.productDiscout = calculateDiscount((packageNow.expirationDate),"vegetables");
						vegetaItem.producTotalPrice = applyDiscount(packageNow.productDetails.price, vegetaItem.productDiscout);
						vegetaItem.productDiscoutValue = (packageNow.productDetails.price - vegetaItem.producTotalPrice);


					}
				}
				result.vegetaTotalQty += (vegetaItem.producUnitTotal);
				result.vegetaTotalPrice += (vegetaItem.producTotalPrice);
				result.vegetaList.add(vegetaItem);

			}

			if (packageNow.productDetails.category.toLowerCase().trim().contentEquals("others")) {
				SummaryProducModel otherItem = new SummaryProducModel();
				if (packageNow.productDetails.name.toLowerCase().trim().contentEquals("cracker")) {
					otherItem.producUnitTotal = packageNow.productDetails.measure * 2;
					otherItem.productName = packageNow.productDetails.name;
					otherItem.producUnitPrice = (packageNow.productDetails.unitPrice);
					otherItem.productUnit = (packageNow.productDetails.measure);
					otherItem.productDiscout = calculateDiscount((packageNow.expirationDate),"others");
					otherItem.producTotalPrice = applyDiscount(packageNow.productDetails.price, otherItem.productDiscout);
					otherItem.productDiscoutValue = (packageNow.productDetails.price - otherItem.producTotalPrice);
				}
				result.ohterTotalQty += (otherItem.producUnitTotal);
				result.otherTotalPrice += (otherItem.producTotalPrice);
				result.otherlist.add(otherItem);

			}

		}
		return result;
	}


	public static void main(String[] args){
		System.out.println(applyDiscount(100, 0.15));
	}


	public static double applyDiscount(double unitTotalPrice, double discount){
		return unitTotalPrice - (unitTotalPrice * discount);
	}

	public static double calculateDiscount(String expirationDate, String category) throws ParseException {
		SummaryProducModel fruitItem = new SummaryProducModel();
		SummaryDataModel result = new SummaryDataModel();
		double discount = 0;
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat diff = new SimpleDateFormat("dd");
		Date expiration = df.parse(expirationDate);
		Date currentDate = new Date();


		long diffDays = ((new java.util.Date()).getTime() - expiration.getTime()) / -(1000 * 60 * 60 * 24);


		double discountPrice = 0;
		String discountPercentage = "";

		if (category.contains("fruit")) {

			if((diffDays <= 35) && (diffDays > 28)){
				discountPercentage = "10%";
				discountPrice = 0.1;
				return discountPrice;
			}
			if((diffDays <= 28) && (diffDays > 21)){
				discountPercentage = "20%";
				discountPrice =  0.2;
				return discountPrice;
			}
			if((diffDays <= 21) && (diffDays > 14)){
				discountPercentage = "30%";
				discountPrice = 0.3;
				return discountPrice;
			}
			if((diffDays <= 14) && (diffDays > 7)){
				discountPercentage = "40%";
				discountPrice =  0.4;
				return discountPrice;
			}
			if((diffDays <= 7) && (diffDays > 0)){
				discountPercentage = "50%";
				discountPrice = 0.5;
				return discountPrice;
			}
			if(diffDays < 0){
				result.fruitslist.remove(fruitItem);
			}
			else{
				System.out.println("The expiration date is far far away!");
			}

		}

		if (category.contains("vegetable")) {
			if((diffDays <= 28) && (diffDays > 21)){
				discountPercentage = "5%";
				discountPrice =  0.05;
			}
			if((diffDays <= 21) && (diffDays > 14)){
				discountPercentage = "10%";
				discountPrice = 0.1;
				return discountPrice;
			}
			if((diffDays <= 14) && (diffDays > 7)){
				discountPercentage = "15%";
				discountPrice =  0.15;
				return discountPrice;
			}
			if((diffDays <= 7) && (diffDays > 0)){
				discountPercentage = "20%";
				discountPrice = 0.2;
				return discountPrice;
			}
			if(diffDays < 0){
				result.fruitslist.remove(fruitItem);
			}
			else{
				System.out.println("The expiration date is far far away!");
			}
		}

		return discount;

	}

}
