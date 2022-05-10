package com.example.casemodule6.service.profile;

import com.example.casemodule6.model.entity.Profile;
import com.example.casemodule6.repository.IProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ProfileService implements IProfileService {

    @Autowired
    private IProfileRepository profileRepository;

    @Override
    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void removeById(Long id) {
        profileRepository.deleteById(id);
    }
}
