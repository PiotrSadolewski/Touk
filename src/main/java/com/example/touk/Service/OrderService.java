package com.example.touk.Service;

import com.example.touk.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order updateOrder(Order order, Long id);
    void deleteOrder(Long id);
}
