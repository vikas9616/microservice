package com.salon.controllers;

import com.salon.mapper.SalonMapper;
import com.salon.model.Salon;
import com.salon.payload.dto.SalonDTO;
import com.salon.payload.dto.UserDTO;
import com.salon.service.SalonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
@RequiredArgsConstructor
public class SalonController {

    private final SalonService salonService;

    @PostMapping
    public ResponseEntity<SalonDTO> createSalon(@RequestBody SalonDTO salonDTO) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L); // Mocked user ID for demonstration purposes
         Salon createdSalon = salonService.createSalon(salonDTO, userDTO);
         SalonDTO salonDTO1 = SalonMapper.mapToDTO(createdSalon);
        return ResponseEntity.ok(salonDTO1);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SalonDTO> updateSalon(@PathVariable("id") Long salonId, @RequestBody SalonDTO salonDTO) throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L); // Mocked user ID for demonstration purposes
        Salon createdSalon = salonService.updateSalon(salonDTO,userDTO,salonId);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(createdSalon);
        return ResponseEntity.ok(salonDTO1);
    }
    //    http://localhost:8080/api/salons

    @GetMapping
    public ResponseEntity<List<SalonDTO>> getSalons() {

        List<Salon> salons = salonService.getAllSalons();
        List<SalonDTO> salonDTOS = salons.stream().map((salon)->{
            SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
            return salonDTO;
        }).toList();

        return ResponseEntity.ok(salonDTOS);
    }
//    http://localhost:8080/api/salons

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDTO> getSalonById(@PathVariable("salonId") Long salonId) throws Exception{

        Salon createdSalon = salonService.getSalonById(salonId);
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(createdSalon);
        return ResponseEntity.ok(salonDTO1);
    }

//    http://localhost:8080/api/salons/search?city=NewYork
    @GetMapping("/search")
    public ResponseEntity<List<SalonDTO>> searchSalons(
            @RequestParam("city") String city
    ) {

        List<Salon> salons = salonService.getSalonsByCity(city);
        List<SalonDTO> salonDTOS = salons.stream().map((salon)->{
            SalonDTO salonDTO = SalonMapper.mapToDTO(salon);
            return salonDTO;
        }).toList();

        return ResponseEntity.ok(salonDTOS);
    }

    @GetMapping("/owner")
    public ResponseEntity<SalonDTO> getSalonByOwnerId(@PathVariable Long salonId) throws Exception{
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L); // Mocked user ID for demonstration purposes
        Salon createdSalon = salonService.getSalonByOwnerId(userDTO.getId());
        SalonDTO salonDTO1 = SalonMapper.mapToDTO(createdSalon);
        return ResponseEntity.ok(salonDTO1);
    }
}
