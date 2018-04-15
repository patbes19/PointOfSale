package com.company;

public class Product {
    /*
            class contains product details
    */
    private String barcode;
    private String name;
    private double price;

    public Product(String barcode, String name, double price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
