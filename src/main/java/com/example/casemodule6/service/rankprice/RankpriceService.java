package com.example.casemodule6.service.rankprice;

import com.example.casemodule6.model.entity.RankPrice;
import com.example.casemodule6.repository.IRankPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankpriceService implements IRankpriceService {
    @Autowired
    IRankPriceRepository rankPriceRepository;

    @Override
    public Iterable<RankPrice> findAll() {
        return rankPriceRepository.findAll();
    }

    @Override
    public Optional<RankPrice> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RankPrice save(RankPrice rankPrice) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }


}
