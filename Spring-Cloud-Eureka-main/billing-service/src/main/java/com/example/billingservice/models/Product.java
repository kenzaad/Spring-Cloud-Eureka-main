package com.example.billingservice.models;


import lombok.Data;

@Data
public class Product {
    private  Long id;
    private String nom;
    private double price;
    private double quantity;

}
