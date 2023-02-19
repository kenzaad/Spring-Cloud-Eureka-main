package com.example.billingservice.entities;

import com.example.billingservice.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
@Entity
 @Data
@AllArgsConstructor @NoArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItem;
    private long  customerID;
    @Transient
    private Customer customer;
    public double getTotal()
    {
        double sum = 0;
        for (ProductItem p : productItem)
        {
            sum += p.getPrice();
        }
        return sum;
    }

}
