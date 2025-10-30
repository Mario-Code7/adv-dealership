package com.yearup.dealership;

public class SalesContract extends Contract {

    private double salesTaxAmount;
    private double recordingFee;
    private double fee;
    private boolean isFinance;

    public SalesContract(String date, String customerName, String customerEmail, double salesTaxAmount, double recordingFee, double fee, boolean isFinance) {
        super(date, customerName, customerEmail);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.fee = fee;
        this.isFinance = isFinance;
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

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public boolean isFinance() {
        return isFinance;
    }

    public void setFinance(boolean finance) {
        isFinance = finance;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
