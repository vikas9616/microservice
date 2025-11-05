package com.booking.mapper;

import com.booking.dto.BookingDTO;
import com.booking.model.Booking;

public class BookingMapper {
    public static BookingDTO toDTO(Booking booking) {
        BookingDTO dto = new BookingDTO();
        dto.setId(booking.getId());
        dto.setSalonId(booking.getSalonId());
        dto.setCustomerId(booking.getCustomerId());
        dto.setStartTime(booking.getStartTime());
        dto.setEndTime(booking.getEndTime());
        dto.setServiceIds(booking.getServiceIds());
        dto.setStatus(booking.getStatus());
//        dto.setTotalPrice(booking.getTotalPrice());
        return dto;
    }
}
