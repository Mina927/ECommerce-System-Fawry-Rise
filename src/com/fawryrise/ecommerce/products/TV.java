package com.fawryrise.ecommerce.products;
import com.fawryrise.ecommerce.interfaces.Shippable;
import com.fawryrise.ecommerce.mangement.Product;

public class TV extends Product implements Shippable {
private double weight;

public TV(double price, int quantity, double weight) {
    super("TV", price, quantity);
    this.weight = weight;
}

@Override
public double getWeight() {
    return weight;
}

}
