package com.fawryrise.ecommerce.mangement;

public class Customer {
    private String name;
    private double balance;
    
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void pruchase(double price){
        if(price > balance){
            throw new IllegalArgumentException("Insufficient Balance.");
        }
        else{
            balance-=price;
        }
    }

}
