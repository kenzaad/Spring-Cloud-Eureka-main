package com.example.billingservice.entities;

import com.example.billingservice.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class ProductItem  {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double price;
    private long productID;
    private  String nom;
 @JsonProperty(access =JsonProperty.Access.WRITE_ONLY)

 @ManyToOne
    private  Bill bill;
    @Transient
    private Product product;

    public double getAmount()
    {
        return price * quantity;
    }

}
