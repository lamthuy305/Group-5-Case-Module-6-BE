package com.example.casemodule6.service.image;

import com.example.casemodule6.model.entity.Image;
import com.example.casemodule6.repository.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService implements IImageService {
    @Autowired
    private IImageRepository imageRepository;

    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image save(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public void removeById(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Iterable<Image> findAllImageByHouseId(Long id) {
        return imageRepository.findAllImageByHouseId(id);
    }
}
