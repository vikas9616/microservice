package com.salon.mapper;

import com.salon.model.Salon;
import com.salon.payload.dto.SalonDTO;

public class SalonMapper {
    public static SalonDTO mapToDTO(Salon salon) {

        SalonDTO salonDTO = new SalonDTO();
        salonDTO.setId(salon.getId());
        salonDTO.setName(salon.getName());
        salonDTO.setImages(salon.getImages());
        salonDTO.setLocation(salon.getLocation());
        salonDTO.setContactNumber(salon.getContactNumber());
        salonDTO.setEmail(salon.getEmail());
        salonDTO.setCity(salon.getCity());
        salonDTO.setOpeningTime(salon.getOpeningTime());
        salonDTO.setClosingTime(salon.getClosingTime());
        return salonDTO;

    }
}
