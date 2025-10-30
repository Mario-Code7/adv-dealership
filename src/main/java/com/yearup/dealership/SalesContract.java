package com.yearup.dealership;

public class SalesContract extends Contract {

    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        super(date, customerName, customerEmail, vehicleSold);
        this.financeOption = financeOption;

        if (vehicleSold.getPrice() < 10000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }


    @Override
    public double getTotalPrice() {
        double basePrice = getVehicleSold().getPrice();
        double saleTax = basePrice * salesTaxAmount;
        return basePrice + saleTax + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double rate;
        int months;

        if (getVehicleSold().getPrice() >= 10000) {
            rate = 0.425 / 12;
            months = 48;
        } else {
            rate = 0.525 / 12;
            months = 24;
        }

        return totalPrice * (rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1);
    }
}
