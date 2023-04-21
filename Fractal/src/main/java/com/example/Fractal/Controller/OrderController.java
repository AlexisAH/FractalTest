package com.example.Fractal.Controller;

import com.example.Fractal.Document.Order;
import com.example.Fractal.Repository.OrderRepository;
import com.example.Fractal.Service.OrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private OrderRepository orderRepository;
    @GetMapping
    public ResponseEntity<List<Order>> getProducts() {
        return new ResponseEntity<List<Order>>(orderService.allOrders(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(orderRepository.save(order), HttpStatus.OK);
    }
    @PostMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable ObjectId id) {
        return new ResponseEntity<Order>(orderService.updateOrder(id), HttpStatus.OK);
    }
}
