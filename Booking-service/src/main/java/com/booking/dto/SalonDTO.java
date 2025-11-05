package com.booking.dto;


import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class SalonDTO {

    private Long id;
    private String name;
    private List<String> images;
    private String location;
    private String contactNumber;
    private String email;
    private String city;
    private Long ownerId;
    private UserDTO owner;
    private LocalTime openingTime;
    private LocalTime closingTime;
}
