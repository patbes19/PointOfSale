package com.company;

public class MockLCDDisplay {
    /*
            3 overloaded methods prepare data for LCD display
            each method accept different inputs
            inputs are processed to send to LCD
    */
    public void print(String receiptItem, double receiptTotal) {
        sendToDisplay(receiptItem, "TOTAL\t" + String.valueOf(receiptTotal));
    }

    public void print(Product product, double receiptTotal) {

        StringBuilder receiptItem = new StringBuilder(product.getName());
        receiptItem.append("\t");
        receiptItem.append(product.getPrice());

        sendToDisplay(receiptItem.toString(), "TOTAL\t" + String.valueOf(receiptTotal));
    }

    public void print(double receiptTotal) {
        sendToDisplay("", "TOTAL\t" + String.valueOf(receiptTotal));
    }

    private void sendToDisplay(String firstLine, String secondLine) {
        /*
            method sends data to LCD display
            simulated LCD contains header and 2 lines of data
         */
        System.out.println("==============LCD==============");
        System.out.print(firstLine);
        System.out.println();
        System.out.print(secondLine);
        System.out.println("\n===============================");
    }
}