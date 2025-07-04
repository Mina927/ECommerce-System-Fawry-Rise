package com.fawryrise.ecommerce.products;
import com.fawryrise.ecommerce.interfaces.Shippable;
import com.fawryrise.ecommerce.mangement.Product;

public class Mobile extends Product implements Shippable{
    private double weight;
    public Mobile(double price, int quanitity, double weight){
    super("Mobile",price,quanitity);
    this.weight=weight;
    }
    @Override
    public double getWeight() {
       return weight;
    }
    
}
