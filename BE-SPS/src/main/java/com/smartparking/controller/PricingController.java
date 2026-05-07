package com.smartparking.controller;

import com.smartparking.entity.Pricing;
import com.smartparking.service.PricingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
@CrossOrigin("*")
public class PricingController {

    private final PricingService pricingService;

    public PricingController(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    // CREATE
    @PostMapping
    public Pricing create(@RequestBody Pricing pricing) {
        return pricingService.create(pricing);
    }

    // READ ALL
    @GetMapping
    public List<Pricing> getAll() {
        return pricingService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Pricing getById(@PathVariable Long id) {
        return pricingService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Pricing update(@PathVariable Long id, @RequestBody Pricing pricing) {
        return pricingService.update(id, pricing);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        pricingService.delete(id);
        return "Deleted successfully";
    }
}