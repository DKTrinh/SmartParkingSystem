package com.smartparking.service;

import com.smartparking.entity.Device;
import com.smartparking.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    public Device createDevice(Device device) {
        device.setLast_seen(LocalDateTime.now());
        return deviceRepository.save(device);
    }

    public Optional<Device> updateDevice(Long id, Device deviceDetails) {
        Optional<Device> optional = deviceRepository.findById(id);

        if (optional.isPresent()) {
            Device d = optional.get();
            d.setType(deviceDetails.getType());
            d.setParkingSlot(deviceDetails.getParkingSlot());
            d.setLast_seen(LocalDateTime.now());
            return Optional.of(deviceRepository.save(d));
        }

        return Optional.empty();
    }

    public boolean deleteDevice(Long id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}