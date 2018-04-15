package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MockPrinter {

    public boolean print(Receipt receipt) {
        /*
            method prepares data for printer
         */
        List<String> receiptToPrint = new LinkedList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        receiptToPrint.add("Receipt");
        receiptToPrint.add(dateFormat.format(new Date()));
        receiptToPrint.add("-------------------");
        if(receipt.getReceiptList() != null) {
            for(Product product : receipt.getReceiptList()) {
                receiptToPrint.add(product.getName() + "\t" + product.getPrice());
            }
            receiptToPrint.add("-------------------");
        }
        receiptToPrint.add("TOTAL\t" + receipt.getTotal());

        return sendToPrinter(receiptToPrint);
    }

    private boolean sendToPrinter(List<String> receiptToPrint) {
        /*
            method sends data to printer
            simulated printer prints on screen header and prepared data
            if list to print is empty then 'false' status is returned
         */
        if(receiptToPrint == null)
            return false;

        System.out.println("============PRINTER============");

        for(String lineToPrint : receiptToPrint) {
            System.out.println(lineToPrint);
        }

        System.out.println("===============================");

        return true;
    }
}
