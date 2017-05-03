package com.warehouse.data;

public class SummaryProducModel {
	public String productName;
	public double productUnit;
	public double producUnitTotal;
	public double producUnitPrice;
	public double producTotalPrice;
	public double productDiscout;
	public double productDiscoutValue;

	
	
	public String toString(){
		return ": " + productName +  ": " + productUnit +  " (" + producUnitTotal +  "), Unit Price " + producUnitPrice + ", Total Price : " + producTotalPrice + ", Discount: " + productDiscout + "% (" + productDiscoutValue + ")";
	}

}
