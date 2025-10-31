package com.yearup.dealership;

import java.util.ArrayList;
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
            System.out.println("2. List 10 contracts");
            System.out.println("0. Exit");
            System.out.println("*********************************");
            System.out.print("Enter your choice: ");
            choice = myScanner.nextInt();
            myScanner.nextLine();

            switch (choice) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:


            }
        }
    }

    private void listAllVehicles() {
        ArrayList<Contract> contracts = contractDataManager.loadContracts();

        if (contracts.isEmpty()) {
            System.out.println("No contracts found!");
        } else {
            for (Contract contract: contracts) {
                System.out.println(contract);
                System.out.println("****************************");
            }
        }
    }

    private void listTenContracts() {
        ArrayList<Contract> contracts = contractDataManager.loadContracts();


    }
}
