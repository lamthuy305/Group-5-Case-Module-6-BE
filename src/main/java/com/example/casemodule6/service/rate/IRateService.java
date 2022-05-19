package com.example.casemodule6.service.rate;

import com.example.casemodule6.model.entity.Rate;
import com.example.casemodule6.service.IGeneralService;

import java.util.Optional;

public interface IRateService extends IGeneralService<Rate> {
    Iterable<Rate> findAllByHouseId(Long houseId);

    Optional<Rate> findRateByUserIdAndHouId(Long user_id,Long house_id);

    double showTotalRateByHouseId(Long houseId);
}
