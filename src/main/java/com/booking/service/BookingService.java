package com.booking.service;

import com.booking.model.Booking;
import com.booking.model.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {

    private static List<Customer> customerList = new ArrayList<>();

    public List<Booking> getAllTodayBookings() {
        return customerList
                .stream().filter(date -> date.getBookingDate().equals(LocalDate.now()))
                .map(c -> new Booking(c.getFirstName() + " " +
                                c.getLastName(),
                                c.getTableSize(),
                                c.getBookingDate().toString(),
                                c.getBookingTime().toString()))
                .collect(Collectors.toList());
    }

    public void createCustomerBooking(Customer customer) {
        customerList.add(customer);
    }
}
