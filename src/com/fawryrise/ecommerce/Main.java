package com.fawryrise.ecommerce;
import java.time.LocalDate;
import com.fawryrise.ecommerce.mangement.Cart;
import com.fawryrise.ecommerce.mangement.Checkout;
import com.fawryrise.ecommerce.mangement.Customer;
import com.fawryrise.ecommerce.products.Biscuits;
import com.fawryrise.ecommerce.products.Cheese;
import com.fawryrise.ecommerce.products.Mobile;
import com.fawryrise.ecommerce.products.ScratchCard;
import com.fawryrise.ecommerce.products.TV;

public class Main {
    public static void main(String[] args){
        Cheese cheese = new Cheese(100,10,0.2,LocalDate.now().plusDays(5));
        Biscuits biscuits = new Biscuits(150, 5, 0.7, LocalDate.now().plusDays(2));
        TV tv = new TV(300, 3, 5);
        ScratchCard scratchCard = new ScratchCard(50, 20);
        Mobile mobile = new Mobile(600, 5, 0.15);
        Customer customer = new Customer("Mina Adel", 3000);
        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits,5);
        cart.add(tv,1);
        cart.add(scratchCard,3);
        cart.add(mobile,1);

        Checkout checkout = new Checkout();
        checkout.checkout(customer, cart);
        System.out.println("---------------------");
        System.out.println("Customer balance after checkout : "+customer.getBalance());
    }
}
