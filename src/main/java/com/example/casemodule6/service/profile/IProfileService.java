package com.example.casemodule6.service.profile;

import com.example.casemodule6.model.entity.Profile;
import com.example.casemodule6.service.IGeneralService;

public interface IProfileService extends IGeneralService<Profile> {
    Profile findByUserId(Long user_id);
}
