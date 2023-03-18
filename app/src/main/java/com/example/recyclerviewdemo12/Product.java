package com.example.recyclerviewdemo12;

import androidx.annotation.NonNull;

public class Product {

    String itemName="";
    int price=0;
    int imageID=0;

    public  Product(){}

    public Product(String itemName, int price, int imageID) {
        this.itemName = itemName;
        this.price = price;
        this.imageID = imageID;
    }

    @NonNull
    @Override
    public String toString() {
        return itemName + ", " + price;
    }
}
