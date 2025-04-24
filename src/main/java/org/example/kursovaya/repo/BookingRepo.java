package org.example.kursovaya.repo;

import org.example.kursovaya.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.UUID;


public interface BookingRepo extends JpaRepository<Booking, UUID> {
    List<Booking> getBookingByClientId(UUID clientId);
}
