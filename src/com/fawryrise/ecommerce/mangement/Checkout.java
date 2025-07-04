package com.fawryrise.ecommerce.mangement;
import java.util.ArrayList;
import java.util.List;
import com.fawryrise.ecommerce.interfaces.Expirable;
import com.fawryrise.ecommerce.interfaces.Shippable;

public class Checkout {
private static final double SHIPPING_RATE = 30.0;
public void checkout(Customer customer, Cart cart){
    if(cart.isEmpty()){
        throw new IllegalArgumentException("Cart is Empty");
    }
    double subtotal = 0;
    double totalWeight = 0;
    List<Shippable> shippableItems= new ArrayList<>();
    for(CartItem item : cart.getItems()){
        Product product = item.getProduct();
        if(product instanceof Expirable){
            Expirable exp = (Expirable) product;
            if(exp.isExpired()){
                throw new IllegalArgumentException("Product Expired : "+product.getName());
            }
        }
        if(item.getQuantity()>product.getQuantity()){
            throw new IllegalArgumentException("Not enought Quantity in stock for "+product.getName());

        }
        subtotal += product.getPrice()*item.getQuantity();

        if(product instanceof Shippable){
            Shippable shippable = (Shippable) product;
            for(int i = 0; i < item.getQuantity();i++){
                shippableItems.add(shippable);
                totalWeight+=shippable.getWeight();
            }
        }
    }

    double shippingCost = totalWeight > 0 ? SHIPPING_RATE : 0;
    double total = subtotal + shippingCost;

    if(customer.getBalance()<total){
        throw new IllegalArgumentException("Insufficent Balance");
    }
    for(CartItem item : cart.getItems()){
        item.getProduct().reduceQuantity(item.getQuantity());
    }

    customer.pruchase(total);

    if(!shippableItems.isEmpty()){
        System.out.println("***Shipment Notice***");
        double wgt = 0;
        for(Shippable shippable:shippableItems){
            System.out.println(shippable.getName()+ " " +shippable.getWeight()*1000 + "gm");
            wgt += shippable.getWeight();
        }
        System.out.println("Total package weight "+wgt+"KG");
        System.out.println("---------------------");
    }


    System.out.println("** Checkout Receipt");
    for(CartItem item: cart.getItems()){
        System.out.printf("%dx %s %.0f%n",item.getQuantity(),item.getProduct().getName(),item.getProduct().getPrice()*item.getQuantity());

    }
    System.out.println("----------------------");
    System.out.println("Subtotal "+subtotal);
    System.out.println("Shippng "+shippingCost);
    System.out.println("Amount "+total);
}
}
