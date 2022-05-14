package com.example.casemodule6.service.house;

import com.example.casemodule6.model.entity.House;
import com.example.casemodule6.service.IGeneralService;

public interface IHouseService extends IGeneralService<House> {
    Iterable<House> find5HouseTopRent();

    Iterable<House> random9House();
}
