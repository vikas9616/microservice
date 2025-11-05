package com.offering.service.impl;

import com.offering.dto.CategoryDTO;
import com.offering.dto.SalonDTO;
import com.offering.dto.ServiceDTO;
import com.offering.model.ServiceOffering;
import com.offering.repository.ServiceOfferingRepository;
import com.offering.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {
    private final ServiceOfferingRepository serviceOfferingRepository;
    @Override
    public ServiceOffering createService(SalonDTO salonDTO, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
       ServiceOffering serviceOffering = new ServiceOffering();
       serviceOffering.setName(serviceDTO.getName());
       serviceOffering.setDescription(serviceDTO.getDescription());
       serviceOffering.setPrice(serviceDTO.getPrice());
       serviceOffering.setDuration(serviceDTO.getDuration());
       serviceOffering.setSalonId(salonDTO.getId());
       serviceOffering.setCategoryId(categoryDTO.getId());
       serviceOffering.setImageUrl(serviceDTO.getImageUrl());
       return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering service) throws Exception {
        ServiceOffering existingService = serviceOfferingRepository.findById(serviceId)
                .orElse(null);
        if (existingService == null) {
            throw new Exception("Service not found with id: " + serviceId);
        }
        existingService.setName(service.getName());
        existingService.setDescription(service.getDescription());
        existingService.setPrice(service.getPrice());
        existingService.setDuration(service.getDuration());
        existingService.setImageUrl(service.getImageUrl());
        return serviceOfferingRepository.save(existingService);
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalonId(Long salonId, Long categoryId) {
        Set<ServiceOffering> services = Set.copyOf(serviceOfferingRepository.findBySalonId(salonId));
        if (categoryId != null) {
            services = services.stream()
                    .filter(service -> service.getCategoryId().equals(categoryId))
                    .collect(java.util.stream.Collectors.toSet());
        }
        return services;
    }

    @Override
    public Set<ServiceOffering> getServicesByIds(Set<Long> ids) {
        List<ServiceOffering> services = serviceOfferingRepository.findAllById(ids);
        if (!services.isEmpty()) {
            return Set.copyOf(services);
        }
        return new HashSet<>(services);
    }

    @Override
    public ServiceOffering getServiceById(Long id) throws Exception {
        ServiceOffering existingService = serviceOfferingRepository.findById(id)
                .orElse(null);
        if (existingService == null) {
            throw new Exception("Service not found with id: " + id);
        }
        return existingService;
    }
}
