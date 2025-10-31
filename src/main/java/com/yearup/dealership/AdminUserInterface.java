package com.yearup.dealership;

import java.util.Scanner;

public class AdminUserInterface {
    private final Scanner myScanner = new Scanner(System.in);
    private final ContractDataManager contractDataManager = new ContractDataManager();

    public void display() {
        int choice;
        do {
            System.out.println("\n*********************");
            System.out.println("      Admin Home       ");
            System.out.println("*********************\n");
            System.out.println("1. List all contracts");

            System.out.println("*********************************");
            System.out.print("Enter your choice: ");
        }
    }
}
