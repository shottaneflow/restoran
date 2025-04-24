package org.example.kursovaya.repo;


import org.example.kursovaya.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;


public interface OrderRepo  extends JpaRepository<Order, UUID> {
    List<Order> findByClientId(UUID clientId);
}
