package org.example.kursovaya.controller;


import org.example.kursovaya.model.Booking;
import org.example.kursovaya.model.Client;
import org.example.kursovaya.service.BookingService;
import org.example.kursovaya.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking-api")
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;
    public BookingController(BookingService bookingService,
                             UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<?> getBookingsByUser(Principal principal) {
        Client client=this.userService.findByUsername(principal.getName());
        List<Booking> bookings=this.bookingService.getBookingsByUser(client.getId());
        return ResponseEntity.ok(bookings);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createBooking(Principal principal, @RequestBody Booking booking) {
        Client client=this.userService.findByUsername(principal.getName());
        booking.setClient(client);
        this.bookingService.save(booking);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBooking(Principal principal, @PathVariable UUID id, @RequestBody Booking booking) {
        booking.setId(id);
        Client client=this.userService.findByUsername(principal.getName());
        booking.setClient(client);
        this.bookingService.save(booking);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable UUID id) {
        this.bookingService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookingById(@PathVariable UUID id) {
        Booking booking=this.bookingService.getBookingById(id);
        return ResponseEntity.ok().body(booking);
    }
}
