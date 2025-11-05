package com.salon.service;

import com.salon.model.Salon;
import com.salon.payload.dto.SalonDTO;
import com.salon.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {

    // Define service methods here
    Salon createSalon(SalonDTO salon, UserDTO user);
    List<Salon> getAllSalons();
    Salon getSalonById(Long salonId) throws Exception;
    Salon updateSalon(SalonDTO salon, UserDTO user, Long id) throws Exception;
    Salon getSalonByOwnerId(Long ownerId);
    List<Salon> getSalonsByCity(String city);

}
