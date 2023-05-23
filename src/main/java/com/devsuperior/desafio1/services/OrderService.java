package com.devsuperior.desafio1.services;

import com.devsuperior.desafio1.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order, double discountPercent) {
        double basic = order.getBasic();
        double discount = basic * (discountPercent / 100);
      return basic - discount + shippingService.shipment(order.getBasic());
    }
}
