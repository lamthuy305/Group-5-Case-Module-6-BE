package com.example.casemodule6.service.house;

import com.example.casemodule6.model.entity.House;
import com.example.casemodule6.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService implements IHouseService{
    @Autowired
    IHouseRepository houseRepository;

    @Override
    public Iterable<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    public void deleteById(Long id) {
        houseRepository.deleteById(id);
    }
}
