package com.example.casemodule6.service.house;

import com.example.casemodule6.model.entity.House;
import com.example.casemodule6.model.entity.RankBathroom;
import com.example.casemodule6.model.entity.RankBedroom;
import com.example.casemodule6.model.entity.RankPrice;
import com.example.casemodule6.service.IGeneralService;

public interface IHouseService extends IGeneralService<House> {
    Iterable<House> find5HouseTopRent();

    Iterable<House> random9House();

    RankPrice checkRankPriceOfHouse(double price);

    RankBathroom checkRankBathroomOfHouse(double number);

    RankBedroom checkRankBedroomOfHouse(double number);

    Iterable<House> findAllByUserId(Long id);

    Iterable<House> search9House(String city, String bedroom, String bathroom, String price, String type);

}
