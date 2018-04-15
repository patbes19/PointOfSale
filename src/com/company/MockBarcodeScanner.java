package com.company;

import java.util.Scanner;

public class MockBarcodeScanner {

    private String barcode;
    private static final String EMPTY_STRING = "";

    public MockBarcodeScanner() {
        this.barcode = EMPTY_STRING; //initialize barcode with empty string
    }

    public String getBarcode() {
        return barcode;
    }

    public boolean scanBarcode() {
        /*
            scan barcode method to simulate scanning
         */
        Scanner barcodeScanner = new Scanner(System.in);
        System.out.print("Enter bar code: ");
        this.barcode = barcodeScanner.nextLine();
        return true;
    }

    public boolean evaluateBarcode() {
        /*
            base evaluation of scanned barcode
            if barcode is empty then return error
         */
        if(this.barcode.equals(EMPTY_STRING))
            return false;

        return true;
    }
}