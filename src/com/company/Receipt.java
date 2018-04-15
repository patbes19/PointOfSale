package com.company;

import java.util.LinkedList;
import java.util.List;

public class Receipt {
    /*
        class contains details of current receipt
     */
    private List<Product> receiptList;
    private double total;

    public Receipt() {
        this.receiptList = new LinkedList<>();
        this.total = 0.0;
    }

    public List<Product> getReceiptList() {
        return receiptList;
    }

    public double getTotal() {
        return total;
    }

    public void addToReceipt(Product product) {
        //add product to receipt
        receiptList.add(product);
        //total price with 2 digit precision
        double tempDoubleTotal = (100 * this.total) + (100 * product.getPrice());
        int tempIntTotal = (int)tempDoubleTotal;
        this.total = (double)tempIntTotal / 100;
    }
}