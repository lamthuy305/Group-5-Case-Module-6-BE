package com.example.casemodule6.service.rate;

import com.example.casemodule6.model.entity.Rate;
import com.example.casemodule6.repository.IRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RateService implements IRateService {
    @Autowired
    private IRateRepository rateRepository;

    @Override
    public Iterable<Rate> findAll() {
        return rateRepository.findAll();
    }

    @Override
    public Optional<Rate> findById(Long id) {
        return rateRepository.findById(id);
    }

    @Override
    public Rate save(Rate rate) {
        return rateRepository.save(rate);
    }

    @Override
    public void removeById(Long id) {
        rateRepository.deleteById(id);
    }

    @Override
    public Iterable<Rate> findAllByHouseId(Long houseId) {
        return rateRepository.findAllByHouseId(houseId);
    }

    @Override
    public double showTotalRateByHouseId(Long houseId) {
        return rateRepository.showTotalRateByHouseId(houseId);
    }
}
