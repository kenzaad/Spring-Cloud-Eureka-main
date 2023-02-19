package me.Alla.kafkabillingproducer.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.Alla.kafkabillingproducer.models.Product;


@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductItem {

    private Long id;
    private double quantity;
    private double price;
    private String productId;

    private Product product;

    private Order order;

    public double getAmount()
    {
        return price * quantity;
    }

}
