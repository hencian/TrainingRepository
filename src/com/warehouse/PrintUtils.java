package com.warehouse;

import com.warehouse.data.SummaryDataModel;
import com.warehouse.data.SummaryProducModel;

public class PrintUtils {

	public static void printSummary(SummaryDataModel summary) {
		System.out.println("--- Print fruit data ---");
		System.out.println("Total: " + summary.fruitTotalQty + " Kg, Total Price: " + summary.fruitTotalPrice);
		int index = 0;
		for (SummaryProducModel iterable_element : summary.fruitslist) {
			System.out.println(index++ + " - " + iterable_element.toString());
		}


		System.out.println("--- Print Vegetables data ---");
		System.out.println("Total: " + summary.vegetaTotalQty + " Kg, Total Price: " + summary.vegetaTotalPrice);
		index = 0;
		for (SummaryProducModel iterable_element : summary.vegetaList) {
			System.out.println(index++ + " - " + iterable_element.toString());
		}

		System.out.println("--- Print others data ---");
		System.out.println("Total: " + summary.ohterTotalQty + " Pack, Total Price: " + summary.otherTotalPrice);
		index = 0;
		for (SummaryProducModel iterable_element : summary.otherlist) {
			System.out.println(index++ + " - " + iterable_element.toString());
		}


	}
}
