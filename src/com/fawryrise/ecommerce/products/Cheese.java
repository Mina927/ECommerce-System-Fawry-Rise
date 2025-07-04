package com.fawryrise.ecommerce.products;
import java.time.LocalDate;
import com.fawryrise.ecommerce.interfaces.Expirable;
import com.fawryrise.ecommerce.interfaces.Shippable;
import com.fawryrise.ecommerce.mangement.Product;

public class Cheese extends Product implements Shippable,Expirable {
     double weight;
     private LocalDate expiryDate;
     
     public Cheese(double price, int quantity, double weight, LocalDate expiryDate) {
        super("Cheese", price, quantity);
        this.weight = weight;
        this.expiryDate = expiryDate;
     }

     @Override
     public double getWeight() {
       return weight;
     }

     @Override
     public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
     }
     
}
