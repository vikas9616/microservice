package com.booking.dto;

import lombok.Data;
@Data

public class ServiceDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer duration;
    private Long salonId;
    private Long Category;
    private String imageUrl;
}
