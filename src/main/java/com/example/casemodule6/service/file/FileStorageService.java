package com.example.casemodule6.service.file;

import com.example.casemodule6.model.entity.Image;
import com.example.casemodule6.repository.IImageRepository;
import com.example.casemodule6.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FileStorageService implements IImageService {
    @Autowired
    IImageRepository fileRepository;

    @Override
    public Iterable<Image> findAll() {
        return fileRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return fileRepository.findById(id);
    }

    @Override
    public Image save(Image image) {
        return fileRepository.save(image);
    }

    @Override
    public void removeById(Long id) {
        fileRepository.deleteById(id);
    }
}
