package com.fawryrise.ecommerce.products;
import java.time.LocalDate;
import com.fawryrise.ecommerce.interfaces.Expirable;
import com.fawryrise.ecommerce.interfaces.Shippable;
import com.fawryrise.ecommerce.mangement.Product;

public class Biscuits extends Product implements Shippable,Expirable{
    private double weight;
    private LocalDate expiryDate;
    public Biscuits(double price, int quantity, double weight, LocalDate expiryDate) {
        super("Biscuits", price, quantity);
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
