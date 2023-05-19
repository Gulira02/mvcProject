package peaksoft.service;

import peaksoft.model.Booking;
import peaksoft.model.Customer;
import peaksoft.model.House;

public interface BookingService {
    Booking getBookingById(Long bookingId);
    Customer getCustomerByBookingId(Long bookingId);
    House getHouseByBookingId(Long bookingId);
}
