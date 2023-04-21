package com.example.Fractal.Service;

import com.example.Fractal.Document.Order;
import com.example.Fractal.Repository.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> allOrders() {
        return orderRepository.findAll();
    }
    public Optional<Order> getProductById(ObjectId id) {
        return orderRepository.findById(id);
    }
    public Order updateOrder(ObjectId id) {
        return orderRepository.save(getProductById(id).get());
    }
}
