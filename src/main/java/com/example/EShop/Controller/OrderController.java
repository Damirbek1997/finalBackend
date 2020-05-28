package com.example.EShop.Controller;

import com.example.EShop.Model.Order;
import com.example.EShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ResponseBody
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    // Get by id
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Integer id) throws Exception {
        return orderService.findById(id);
    }

    // Change by id
    @PutMapping("/{id}")
    public Order putOrder(@PathVariable ("id") Integer id ,@RequestBody Order order) throws Exception {
        orderService.changeById(id,order);
        return order;
    }

    // Create order
    @PostMapping
    public Order postOrder(@RequestBody Order order) throws Exception {
        orderService.createOrder(order);
        return order;
    }

    // Delete order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable ("id") Integer id) {
        orderService.deleteById(id);
    }

    // Get all orders
    @GetMapping(value = "/all")
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    // Get all orders of user
    @GetMapping(value = "/user/email")
    public List<Order> getOrdersByUserId(@PathVariable("email") String email) {
        return orderService.getByUser(email);
    }
}
