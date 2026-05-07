package com.smartparking.service;

import com.smartparking.entity.*;
import com.smartparking.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigPriceService {

    @Autowired
    private ConfigPriceRepository repo;

    public List<ConfigPrice> getAllConfigs() {
        return repo.findAll();
    }

    public ConfigPrice create(ConfigPrice c) {
        return repo.save(c);
    }

    public ConfigPrice update(Long id, ConfigPrice c) {
        c.setId(id);
        return repo.save(c);
    }
}