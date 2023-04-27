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
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    public Order updateOrder(String id,Order order) {
        Order orderdb= orderRepository.findById(id).orElseThrow(RuntimeException::new);
        orderdb.setOrderNumber(order.getOrderNumber());
        orderdb.setDate(order.getDate());
        orderdb.setFinalPrice(order.getFinalPrice());
        orderdb.setProductNumber(order.getProductNumber());
        orderdb.setProductsIds(order.getProductsIds());
        return orderRepository.save(orderdb);
    }
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

}
