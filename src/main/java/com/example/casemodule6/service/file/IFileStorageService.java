package com.example.casemodule6.service.file;

import com.example.casemodule6.model.entity.Image;
import com.example.casemodule6.repository.IFileRepository;
import com.example.casemodule6.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface IFileStorageService extends IGeneralService<Image> {
}
