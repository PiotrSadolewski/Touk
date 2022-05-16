package com.example.touk.ServiceImpl;

import com.example.touk.Service.OrderService;
import com.example.touk.model.Order;
import com.example.touk.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("could not find Order with id: " + id));
    }

    @Override
    public Order updateOrder(Order order, Long id) {
        Order existingORder = orderRepository.findById(id).orElseThrow();
        existingORder.setClient(order.getClient());
        existingORder.setFinalPrice(order.getFinalPrice());
        existingORder.setTicket(order.getTicket());
        return existingORder;
    }

    @Override
    public void deleteOrder(Long id) {
        Order deleteOrder = orderRepository.findById(id).orElseThrow();
        orderRepository.delete(deleteOrder);
    }
}
