package com.yearup.dealership;

public class Program {
    public static void main(String[] args) {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();

        if (dealership != null) {
            UserInterface ui = new UserInterface(dealership);
            ui.display();
            DealershipFileManager.saveDealership(dealership);
        } else {
            System.out.println("Error! Sorry could not find file.");
        }
    }
}
