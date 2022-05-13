package com.example.casemodule6.service.statusHouse;

import com.example.casemodule6.model.entity.StatusHouse;
import com.example.casemodule6.repository.IStatusHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusHouseService implements IStatusHouseService{
    @Autowired
    IStatusHouseRepository statusHouseRepository;

    @Override
    public Iterable<StatusHouse> findAll() {
        return statusHouseRepository.findAll();
    }

    @Override
    public Optional<StatusHouse> findById(Long id) {
        return statusHouseRepository.findById(id);
    }

    @Override
    public StatusHouse save(StatusHouse statusHouse) {
        return statusHouseRepository.save(statusHouse);
    }

    @Override
    public void removeById(Long id) {
        statusHouseRepository.deleteById(id);
    }
}
