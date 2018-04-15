package com.company;

public class Main {

    //define IO devices
    public static MockBarcodeScanner mockBarcodeScanner = new MockBarcodeScanner();
    public static MockLCDDisplay mockLCDDisplay = new MockLCDDisplay();
    public static MockDatabase mockDatabase = new MockDatabase();
    public static MockPrinter mockPrinter = new MockPrinter();

    public static void main(String[] args) {

        //connect to database
        if(!mockDatabase.connect()) {
            System.out.println("Cannot connect to database");
        }

        //create new receipt
        Receipt newReceipt = new Receipt();

        //scan code, query from database, save products
        boolean scanBarCode = true;
        do{
            //'scanning error' when scan method returns error
            if(!mockBarcodeScanner.scanBarcode()) {
                System.out.println("Scanning error");
                continue;   //finish current iteration of loop
            }

            //'invalid barcode' when scanned code is empty
            if(!mockBarcodeScanner.evaluateBarcode()) {
                mockLCDDisplay.print("Invalid barcode", newReceipt.getTotal());
                continue;
            }

            //close receipt when scanned code is 'exit'
            if(mockBarcodeScanner.getBarcode().equalsIgnoreCase("exit")) {
                scanBarCode = false;
                continue;
            }

            //query product with scanned code from database
            Product productFromDatabase = mockDatabase.queryProduct(mockBarcodeScanner.getBarcode());

            //evaluate results from query, if returned item is null then product was not found in database
            if(productFromDatabase == null) {
                mockLCDDisplay.print("Product not found", newReceipt.getTotal());
                continue;
            }

            //add scanned product to receipt
            newReceipt.addToReceipt(productFromDatabase);

            //print details of last product on LCD display
            mockLCDDisplay.print(productFromDatabase, newReceipt.getTotal());
        } while(scanBarCode);

        //print total sum on LCD display
        mockLCDDisplay.print(newReceipt.getTotal());

        //print receipt
        if(!mockPrinter.print(newReceipt)) {
            System.out.println("Cannot print receipt");
        }

        //disconnect database
        mockDatabase.disconnect();
    }
}