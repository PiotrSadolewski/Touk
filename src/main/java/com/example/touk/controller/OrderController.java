package com.example.touk.controller;

import com.example.touk.Service.OrderService;
import com.example.touk.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderBy(@PathVariable("id") long orderId){
        return new ResponseEntity<Order>(orderService.getOrderById(orderId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order){
        return new ResponseEntity<Order>(orderService.updateOrder(order, id), HttpStatus.OK);
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<String> deleteOrder(@PathVariable("id") long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<String>("Order :"+ id + " deleted succesfully!", HttpStatus.OK);
    }
}
