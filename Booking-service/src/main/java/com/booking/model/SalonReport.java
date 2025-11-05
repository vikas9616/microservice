package com.booking.model;

import lombok.Data;

@Data
public class SalonReport {
    private Long salonId;
    private String salonName;
    private Integer totalBookings;
    private Integer cancelledBookings;
    private Double totalEarnings;
    private Double totalRefunds;

}
