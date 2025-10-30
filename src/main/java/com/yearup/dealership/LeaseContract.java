package com.yearup.dealership;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee = 0.07;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold );
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return getVehicleSold().getPrice() * 0.5;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return getVehicleSold().getPrice() * leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return getExpectedEndingValue() * getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        double amountFinanced = getTotalPrice();
        return amountFinanced *(0.07 * Math.pow(1 + 0.07, 36)) / (Math.pow(1 + 0.07, 36) - 1);
    }
}
