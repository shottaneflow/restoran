package org.example.kursovaya.controller;


import org.example.kursovaya.model.Booking;
import org.example.kursovaya.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin-api")
public class AdminController {

    private final BookingService bookingService;
    public AdminController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping("/bookings")
    public ResponseEntity<?>getBookings(){
        List<Booking> bookings=this.bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
}
