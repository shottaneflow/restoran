package org.example.kursovaya.repo;

import org.example.kursovaya.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.UUID;


public interface ClientRepo  extends JpaRepository<Client, UUID> {
    Optional<Client> findByUsername(String username);
}
