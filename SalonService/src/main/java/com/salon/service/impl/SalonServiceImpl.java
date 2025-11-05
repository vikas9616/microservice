package com.salon.service.impl;

import com.salon.model.Salon;
import com.salon.payload.dto.SalonDTO;
import com.salon.payload.dto.UserDTO;
import com.salon.repository.SalonRepository;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    @Override
    public Salon createSalon(SalonDTO req, UserDTO user) {
        Salon salon = new Salon();
        salon.setName(req.getName());
        salon.setImages(req.getImages());
        salon.setLocation(req.getLocation());
        salon.setContactNumber(req.getContactNumber());
        salon.setEmail(req.getEmail());
        salon.setCity(req.getCity());
        salon.setOwnerId(user.getId());
        salon.setOpeningTime(req.getOpeningTime());
        salon.setClosingTime(req.getClosingTime());
        return salonRepository.save(salon);
    }

    @Override
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    @Override
    public Salon getSalonById(Long salonId) throws Exception {
        Salon salon = salonRepository.findById(salonId).orElse(null);
        if (salon ==null){
            throw new Exception("Salon not found with id: " + salonId);
        }
        return salon;
    }

    @Override
    public Salon updateSalon(SalonDTO salon, UserDTO user, Long id) throws Exception {
        Salon existingSalon = salonRepository.findById(id).orElse(null);
        if(!salon.getOwnerId().equals(user.getId())){
            throw new Exception("You are not authorized to update this salon");
        }
        if (existingSalon != null ) {
            existingSalon.setName(salon.getName());
            existingSalon.setImages(salon.getImages());
            existingSalon.setLocation(salon.getLocation());
            existingSalon.setContactNumber(salon.getContactNumber());
            existingSalon.setEmail(salon.getEmail());
            existingSalon.setCity(salon.getCity());
            existingSalon.setOpeningTime(salon.getOpeningTime());
            existingSalon.setClosingTime(salon.getClosingTime());
            return salonRepository.save(existingSalon);
        }
            throw new Exception("Salon not exist or you are not authorized to update this salon");
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
         return salonRepository.findByOwnerId(ownerId);


    }

    @Override
    public List<Salon> getSalonsByCity(String city) {
        return salonRepository.searchSalons(city);
    }
}
