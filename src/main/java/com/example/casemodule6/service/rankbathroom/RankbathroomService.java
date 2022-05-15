package com.example.casemodule6.service.rankbathroom;

import com.example.casemodule6.model.entity.RankBathroom;
import com.example.casemodule6.repository.IRankBathroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankbathroomService implements IRankbathroomService {
    @Autowired
    IRankBathroomRepository rankBathroomRepository;

    @Override
    public Iterable<RankBathroom> findAll() {
        return rankBathroomRepository.findAll();
    }

    @Override
    public Optional<RankBathroom> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RankBathroom save(RankBathroom rankBathroom) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
