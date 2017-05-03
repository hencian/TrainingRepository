package Warehouse.src.com.warehouse;

import java.util.ArrayList;
import java.util.List;

import com.warehouse.PrintUtils;
import com.warehouse.WarehouseOperations;
import com.warehouse.data.Package;
import com.warehouse.data.SummaryDataModel;

public class Main {

	public static void main(String args[]) {
		List<Package> warehouseInventory = new ArrayList<Package>();

		for (int i = 0; i < 200; i++) {
			warehouseInventory.add(WarehouseOperations.randomPackageGenerator());
		}

		System.out.println("size: " + warehouseInventory.size());
		System.out.println(warehouseInventory);

		SummaryDataModel summary = WarehouseOperations.generateSummary(warehouseInventory);
		PrintUtils.printSummary(summary);

	}

}
