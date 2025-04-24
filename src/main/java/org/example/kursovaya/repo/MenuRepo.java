package org.example.kursovaya.repo;

import org.example.kursovaya.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepo extends JpaRepository<Menu, UUID> {
}