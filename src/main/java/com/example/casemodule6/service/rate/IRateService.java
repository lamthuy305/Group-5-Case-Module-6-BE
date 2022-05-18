package com.example.casemodule6.service.rate;

import com.example.casemodule6.model.entity.Rate;
import com.example.casemodule6.service.IGeneralService;

public interface IRateService extends IGeneralService<Rate> {
    Iterable<Rate> findAllByHouseId(Long houseId);

    double showTotalRateByHouseId(Long houseId);
}
