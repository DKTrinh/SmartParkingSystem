package com.smartparking.service;
import com.smartparking.dto.CreateParkingLotRequest;
import com.smartparking.dto.ParkingLotResponse;
import com.smartparking.entity.*;
import com.smartparking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParkingLotService {

    @Autowired private ParkingLotRepository repo;

    public List<ParkingLotResponse> getAll() {
        return repo.findAll()
                .stream()
                .map(lot -> new ParkingLotResponse(
                        lot.getId(),
                        lot.getName(),
                        lot.getLocation()
                ))
                .toList();
    }

    public ParkingLotResponse create(CreateParkingLotRequest request) {

        ParkingLot lot = new ParkingLot();
        lot.setName(request.getName());
        lot.setLocation(request.getLocation());

        ParkingLot saved = repo.save(lot);

        return new ParkingLotResponse(
                saved.getId(),
                saved.getName(),
                saved.getLocation()
        );
    }

    public void delete(Long id) {
        repo.findById(id).ifPresent(repo::delete);
    }
}