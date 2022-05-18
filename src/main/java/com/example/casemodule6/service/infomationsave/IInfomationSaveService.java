package com.example.casemodule6.service.infomationsave;

import com.example.casemodule6.model.entity.InfomationSave;
import com.example.casemodule6.service.IGeneralService;

public interface IInfomationSaveService extends IGeneralService<InfomationSave> {
    Iterable<InfomationSave> get10InformationSaveByIdUserActive(Long id);

    Iterable<InfomationSave> getAllInformationSaveByIdUserIsActive(Long id);
}
