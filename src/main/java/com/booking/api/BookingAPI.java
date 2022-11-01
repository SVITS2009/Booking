package com.booking.api;

import com.booking.dto.BookingRequest;
import com.booking.model.Booking;
import com.booking.service.BookingService;
import com.booking.util.Util;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import java.util.List;

@Path("/booking/")
public class BookingAPI {

    private BookingService service = new BookingService();

    @GET
    @Produces("application/json")
    public List<Booking> getDailyBookings(@Context SecurityContext securityContext) {
        if (!securityContext.isUserInRole("Admin")) {
            throw new ClientErrorException("This requires a User role", 403);
        }
        return service.getAllTodayBookings();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String createBooking(@Context SecurityContext securityContext, String requestBody) {
        if (!securityContext.isUserInRole("User")) {
            throw new ClientErrorException("This requires a User role", 403);
        }
        BookingRequest bookingRequest = Util.convertGson2BookingRequest(requestBody);
        service.createCustomerBooking(Util.convertRequest2Customer(bookingRequest));
        return "Booking created successfully";
    }
}
