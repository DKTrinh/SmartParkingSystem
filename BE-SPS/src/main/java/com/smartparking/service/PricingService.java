package com.smartparking.service;

import com.smartparking.entity.Pricing;
import com.smartparking.repository.PricingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PricingService {

    private final PricingRepository pricingRepository;

    public PricingService(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    public Pricing create(Pricing pricing) {
        pricing.setCreatedAt(LocalDateTime.now());
        return pricingRepository.save(pricing);
    }

    public List<Pricing> getAll() {
        return pricingRepository.findAll();
    }

    public Pricing getById(Long id) {
        return pricingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pricing not found"));
    }

    public Pricing update(Long id, Pricing updated) {
        Pricing pricing = getById(id);

        pricing.setType(updated.getType());
        pricing.setPricePerHour(updated.getPricePerHour());
        pricing.setPricePerDay(updated.getPricePerDay());
        pricing.setPricePerMonth(updated.getPricePerMonth());
        pricing.setVehicleType(updated.getVehicleType());

        return pricingRepository.save(pricing);
    }

    public void delete(Long id) {
        Pricing pricing = getById(id);
        pricingRepository.delete(pricing);
    }
}