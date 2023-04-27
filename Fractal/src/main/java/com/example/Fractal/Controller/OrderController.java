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
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/my-orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping()
    public ResponseEntity<List<Order>> getOrders() {
        return new ResponseEntity<List<Order>>(orderService.allOrders(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable String id){
        return new ResponseEntity<Optional<Order>>(orderService.getOrderById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.createOrder(order), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String id,@RequestBody Order order) {
       return new ResponseEntity<Order>(orderService.updateOrder(id,order), HttpStatus.OK);
        //validation data
        /*if(order.getOrderNumber().isEmpty() || order.getDate().isEmpty() || order.getFinalPrice().isEmpty() || order.getProductNumber().isEmpty() || order.getProductsIds().isEmpty()){
            return new ResponseEntity<Order>(orderService.updateOrder(id,order), HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<Order>(orderService.updateOrder(id,order), HttpStatus.OK);
        }*/
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable String id){
        orderService.deleteOrder(id);
        return new ResponseEntity<String>("Order deleted successfully", HttpStatus.OK);
    }
}
