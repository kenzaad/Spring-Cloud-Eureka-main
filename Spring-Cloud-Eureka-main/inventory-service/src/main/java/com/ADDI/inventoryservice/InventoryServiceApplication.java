package com.alla.inventoryservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class InventoryServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }@Bean
CommandLineRunner run(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration)
{
 return args -> {
     restConfiguration.exposeIdsFor(Product.class);
     productRepository.save(new Product(null,"HP COMPAC",10000,800));
     productRepository.save(new Product(null,"SamsungA03",2000,1000));
     productRepository.save(new Product(null,"LG SMART TV ",4300,1200));
    productRepository.findAll().forEach(
            p-> System.out.println(p.toString())
    );
 };
}
}
@Entity
@NoArgsConstructor @AllArgsConstructor
@Data @ToString
class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private double price;
    private double quantity;

}
@RepositoryRestResource
 interface ProductRepository extends JpaRepository<Product,Long>
{

}
