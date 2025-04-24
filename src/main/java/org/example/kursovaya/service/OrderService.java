package org.example.kursovaya.service;


import org.example.kursovaya.model.Order;
import org.example.kursovaya.repo.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public List<Order> getOrdersByUser(UUID userId) {
        return orderRepo.findByClientId(userId);
    }

    public Optional<Order> getOrderById(UUID id) {
        return orderRepo.findById(id);
    }
    public void delete(UUID id) {
        orderRepo.deleteById(id);
    }
    public void save(Order order) {
        orderRepo.save(order);
    }

}
