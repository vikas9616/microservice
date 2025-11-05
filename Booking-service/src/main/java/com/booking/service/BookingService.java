package com.booking.service;

import com.booking.domain.BookingStatus;
import com.booking.dto.BookingRequest;
import com.booking.dto.SalonDTO;
import com.booking.dto.ServiceDTO;
import com.booking.dto.UserDTO;
import com.booking.model.Booking;
import com.booking.model.SalonReport;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking createBooking(BookingRequest booking,
                          UserDTO userDTO,
                          SalonDTO salonDTO,
                          Set<ServiceDTO> serviceDTOSet) throws Exception;
    List<Booking> getBookingsByCustomer(Long customerId);
    List<Booking> getBookingsBySalon(Long salonId);
    Booking getBookingById(Long id) throws Exception;
//    Booking updateBookingStatus(Long bookingId, BookingStatus status) throws Exception;
    List<Booking> getBookingByDate(LocalDate date, Long salonId);
    SalonReport getSalonReport(Long salonId);


    Booking updateBooking(Long bookingId, BookingStatus status) throws Exception;
}
