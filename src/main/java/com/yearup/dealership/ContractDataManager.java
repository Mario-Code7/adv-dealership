package com.yearup.dealership;

import java.io.*;
import java.util.ArrayList;

public class ContractDataManager {

    public void saveContract(Contract contract) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("contracts.csv", true))) {
            Vehicle vehicle = contract.getVehicleSold();

            if (contract instanceof SalesContract sale) {
                printWriter.printf("\nSALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                        sale.getDate(),
                        sale.getCustomerName(),
                        sale.getCustomerEmail(),
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice(),
                        vehicle.getPrice() * 0.05, 100.0,
                        sale.getProcessingFee(), sale.getTotalPrice(), sale.isFinanceOption(), sale.getMonthlyPayment());
            } else if (contract instanceof LeaseContract lease) {
                printWriter.printf("\nLEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f%n",
                        lease.getDate(),
                        lease.getCustomerName(),
                        lease.getCustomerEmail(),
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice(),
                        lease.getExpectedEndingValue(),
                        lease.getLeaseFee(),
                        lease.getTotalPrice(),
                        lease.getMonthlyPayment()
                );

            }
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }

    public ArrayList<Contract> loadContracts() {
        ArrayList<Contract> contracts = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("contracts.csv"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String type = parts[0];
                String date = parts[1];
                String name = parts[2];
                String email = parts[3];
                int vin = Integer.parseInt(parts[4]);
                double price = Double.parseDouble(parts[5]);

                if (type.equalsIgnoreCase("SALE")) {
                    contracts.add(new SalesContract(date, name, email, vin, price));
                } else {
                    contracts.add(new LeaseContract(date, name, email, vin, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contracts: " + e.getMessage());
            return null;
        }
        return contracts;
    }
}
