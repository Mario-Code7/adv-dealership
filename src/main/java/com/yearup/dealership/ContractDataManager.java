package com.yearup.dealership;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ContractDataManager {

    public void saveContract(Contract contract) {
        try(PrintWriter printWriter = new PrintWriter(new FileWriter("contracts.csv", true))) {
            Vehicle vehicle = contract.getVehicleSold();

            if (contract instanceof SalesContract sale) {
                printWriter.printf("SALE | %s | %s | %s | %d | %d | %s | %s | %s | %s | %d | %.2f | %.2f | %.2f | %.2f | %.2f | %s | %.2f",
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
                printWriter.printf("LEASE | %s | %s | %s | %d | %d | %s | %s | %s | %s | %d | %.2f | %.2f | %.2f | %.2f | %.2f%n",
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
        }
    }
}
