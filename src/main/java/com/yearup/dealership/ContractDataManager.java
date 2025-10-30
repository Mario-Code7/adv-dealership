package com.yearup.dealership;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractDataManager {

    public void saveContract(Contract contract) {
            try(PrintWriter printWriter = new PrintWriter(new FileWriter("contracts.csv")) {
                printWriter.println(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
                for (Vehicle vehicle: dealership.getAllVehicles()) {
                    printWriter.println(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());
                }
            } catch (IOException e) {
                System.out.println("Error saving your dealership file details: " + e.getMessage());
            }
        }
    }
}
