package com.fawryrise.ecommerce.mangement;
import java.util.ArrayList;
import java.util.List;

public class Cart {
private List<CartItem> items = new ArrayList<>();

public void add(Product product,int quantity){
    if(quantity > product.getQuantity()){
        try {
             throw new IllegalArgumentException("Not enough quantity in stock");
        } catch (Exception e) {
            System.out.println("Not enough quanitity of "+product.getName()+" in Stock");
        }
       
    }else{
        items.add(new CartItem(product, quantity));
    }
}

public List<CartItem> getItems() {
    return items;
}

public boolean isEmpty(){
    return items.isEmpty();
}
}
