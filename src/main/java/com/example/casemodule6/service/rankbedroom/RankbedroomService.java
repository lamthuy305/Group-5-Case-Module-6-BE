package com.example.casemodule6.service.rankbedroom;

import com.example.casemodule6.model.entity.RankBedroom;
import com.example.casemodule6.repository.IRankBedroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankbedroomService implements IRankbedroomService {
    @Autowired
    IRankBedroomRepository rankBedroomRepository;

    @Override
    public Iterable<RankBedroom> findAll() {
        return rankBedroomRepository.findAll();
    }

    @Override
    public Optional<RankBedroom> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RankBedroom save(RankBedroom rankBedroom) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
