package com.example.EShop.Service;

import com.example.EShop.GlobalVariables.Status;
import com.example.EShop.Model.Order;
import com.example.EShop.Model.Product;
import com.example.EShop.Repository.OrderRepository;
import com.example.EShop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    // Find by id
    public Order findById(Integer id) throws Exception {
        return orderRepository.findById(id).orElseThrow(Exception::new);
    }

    // Delete by id
    public String deleteById(Integer id) {
        orderRepository.deleteById(id);
        return "Order number " + id + " has been deleted!";
    }

    // Change by id
    public Order changeById(Integer id, Order orderEntity) throws Exception {
        return orderRepository.findById(id)
                .map(order-> {
                    order.setOrderDate(orderEntity.getOrderDate());
                    order.setUserEmail(orderEntity.getUserEmail());
                    order.setAddress(orderEntity.getAddress());
                    order.setStatus(orderEntity.getStatus());
                    order.setOrderItems(orderEntity.getOrderItems());
                    return orderRepository.save(order);
                }).orElseThrow( Exception::new);
    }

    // Create order
    public Order createOrder(Order order) throws Exception {
        order.setTotal(calculatePrice(order));
        order.setStatus(Status.NEW);
        order.setOrderDate(Date.from(Instant.now()));
        try {
            Mail.SendEmail((order.getUserEmail()), "Order Made!", order.toString()+"\n Your tracking number : 880535535");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    // Get by user id
    public List<Order> getByUser(String mail){
        return orderRepository.findOrderEntitiesByUserEmail(mail);
    }

    // Calculate price
    public BigDecimal calculatePrice(Order order) throws Exception {
        BigDecimal total = BigDecimal.valueOf(0.0);
        for (Product product : order.getOrderItems()) {
            product.setInStock(false);
            productRepository.save(product);
            total = total.add(product.getPrice());
            order.setTotal(total);
        }
        return total;
    }
}
