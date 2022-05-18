package com.example.casemodule6.service.infomationsave;

import com.example.casemodule6.model.entity.InfomationSave;
import com.example.casemodule6.repository.IInfomationSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfomationSaveService implements IInfomationSaveService {
    @Autowired
    private IInfomationSaveRepository infomationSaveRepository;

    @Override
    public Iterable<InfomationSave> findAll() {
        return infomationSaveRepository.findAll();
    }

    @Override
    public Optional<InfomationSave> findById(Long id) {
        return infomationSaveRepository.findById(id);
    }

    @Override
    public InfomationSave save(InfomationSave infomationSave) {
        return infomationSaveRepository.save(infomationSave);
    }

    @Override
    public void removeById(Long id) {
        infomationSaveRepository.deleteById(id);
    }

    @Override
    public Iterable<InfomationSave> get10InformationSaveByIdUserActive(Long id) {
        return infomationSaveRepository.get10InformationSaveByIdUserActive(id);
    }

    @Override
    public Iterable<InfomationSave> getAllInformationSaveByIdUserIsActive(Long id) {
        return infomationSaveRepository.getAllInformationSaveByIdUserIsActive(id);
    }
}
