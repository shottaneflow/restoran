package org.example.kursovaya.service;

import org.example.kursovaya.model.Booking;
import org.example.kursovaya.repo.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepo bookingRepo;

    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public List<Booking> getBookingsByUser(UUID id){
        return this.bookingRepo.getBookingByClientId(id);
    }
    public void save(Booking booking){
        this.bookingRepo.save(booking);
    }
    public void delete(UUID id){
        this.bookingRepo.deleteById(id);
    }
    public Booking getBookingById(UUID id){
        return this.bookingRepo.getById(id);
    }
    public List<Booking> getAllBookings(){
        return this.bookingRepo.findAll();
    }
}
