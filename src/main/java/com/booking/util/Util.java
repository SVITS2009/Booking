package com.booking.util;

import com.booking.dto.BookingRequest;
import com.booking.model.Customer;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.time.LocalTime;

public class Util {
    public static Customer convertRequest2Customer(final BookingRequest request) {
        return new Customer(request.getFirstName(),
                request.getLastName(),
                request.getEmailId(),
                request.getContactNumber(),
                request.getTableSize(),
                LocalDate.now(),
                LocalTime.now());
    }

    public static BookingRequest convertGson2BookingRequest(String requestBody) {
        Gson gson = new Gson();
        return gson.fromJson(requestBody, BookingRequest.class);
    }
}
