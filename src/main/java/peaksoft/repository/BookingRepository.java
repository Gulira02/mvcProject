package peaksoft.repository;

import peaksoft.model.Booking;
import peaksoft.model.Customer;
import peaksoft.model.House;

public interface BookingRepository {
    Booking getBookingById(Long bookingId);
    Customer getCustomerByBookingId(Long bookingId);
    House getHouseByBookingId(Long bookingId);
}
