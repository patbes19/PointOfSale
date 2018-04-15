package com.company;

import java.util.ArrayList;
import java.util.List;

public class MockDatabase {

    private List<Product> mockProductsDatabase; //real database was replaced with products list

    public MockDatabase() {
        mockProductsDatabase = new ArrayList<>();
        mockProductsDatabaseInitialize(); //initialization of simulated database
    }

    public boolean connect() {
        return true;
    }

    public boolean disconnect() {
        return true;
    }

    public Product queryProduct(String barcode) {
        /*
            query product from database
            statement query was replaced with 'for' loop which search list
            method returns found product or null when product was not found
         */
        for(Product product : mockProductsDatabase) {
            if(barcode.equals(product.getBarcode())) {
                return product;
            }
        }
        return null;
    }

    private void mockProductsDatabaseInitialize() {
        //simulated database
        mockProductsDatabase.add(new Product("1111", "Coffee", 2.5));
        mockProductsDatabase.add(new Product("2222", "Tea", 3.15));
        mockProductsDatabase.add(new Product("3333", "Juice", 7.49));
        mockProductsDatabase.add(new Product("4444", "Cheese", 21.53));
        mockProductsDatabase.add(new Product("5555", "Ham", 19.99));
        mockProductsDatabase.add(new Product("6666", "Pasta", 14.0));
        mockProductsDatabase.add(new Product("7777", "Water", 0.99));
        mockProductsDatabase.add(new Product("8888", "Bread", 5.55));
        mockProductsDatabase.add(new Product("9999", "Chicken", 11.49));
    }
}