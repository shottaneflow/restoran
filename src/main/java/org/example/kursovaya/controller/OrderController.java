package org.example.kursovaya.controller;

import org.example.kursovaya.model.Client;
import org.example.kursovaya.model.Order;
import org.example.kursovaya.service.OrderService;
import org.example.kursovaya.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order-api")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;
    public OrderController(OrderService orderService,
                           UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(Principal principal,@RequestBody Order order) {
        Client client=this.userService.findByUsername(principal.getName());
        order.setClient(client);
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Order>> getUserOrders(Principal principal) {
        Client client=userService.findByUsername(principal.getName());
        return ResponseEntity.ok(client.getOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable UUID id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        this.orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(Principal principal,@PathVariable UUID id, @RequestBody Order order) {
        Client client=this.userService.findByUsername(principal.getName());
        order.setClient(client);
        order.setId(id);
        this.orderService.save(order);
        return ResponseEntity.ok().build();
    }
}
