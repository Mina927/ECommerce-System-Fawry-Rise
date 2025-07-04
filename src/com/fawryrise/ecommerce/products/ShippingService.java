package com.fawryrise.ecommerce.products;
import java.util.List;
import com.fawryrise.ecommerce.interfaces.Shippable;

public class ShippingService {

    public void ship(List<Shippable> items){
        System.out.println("** Shipment Notice **");
        double totalWeight = 0;
        for(Shippable item:items){
            System.out.println(item.getName()+" "+item.getWeight()+"kg");
            totalWeight += item.getWeight();
        }
        System.out.println("total package weight "+totalWeight+"Kg");
    }
}
