package com.example.casemodule6.service.house;

import com.example.casemodule6.model.entity.House;
import com.example.casemodule6.model.entity.RankBathroom;
import com.example.casemodule6.model.entity.RankBedroom;
import com.example.casemodule6.model.entity.RankPrice;
import com.example.casemodule6.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HouseService implements IHouseService {
    @Autowired
    IHouseRepository houseRepository;

    @Override
    public Iterable<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public Optional<House> findById(Long id) {
        return houseRepository.findById(id);
    }

    @Override
    public House save(House house) {
        return houseRepository.save(house);
    }

    @Override
    public void removeById(Long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public Iterable<House> find5HouseTopRent() {
        return houseRepository.find5HouseTopRent();
    }

    @Override
    public Iterable<House> random9House() {
        return houseRepository.random9House();
    }

    @Override
    public RankPrice checkRankPriceOfHouse(double price) {
        if (price < 1000000) return new RankPrice(1L);
        if (price < 2000000) return new RankPrice(2L);
        if (price < 3000000) return new RankPrice(3L);
        if (price < 5000000) return new RankPrice(4L);
        return new RankPrice(5L);
    }

    @Override
    public RankBathroom checkRankBathroomOfHouse(double number) {
        if (number == 1) return new RankBathroom(1L);
        if (number == 2) return new RankBathroom(2L);
        if (number == 3) return new RankBathroom(3L);
        if (number == 4) return new RankBathroom(4L);
        return new RankBathroom(5L);
    }

    @Override
    public RankBedroom checkRankBedroomOfHouse(double number) {
        if (number == 1) return new RankBedroom(1L);
        if (number == 2) return new RankBedroom(2L);
        if (number == 3) return new RankBedroom(3L);
        if (number == 4) return new RankBedroom(4L);
        return new RankBedroom(5L);
    }

    @Override
    public Iterable<House> search9House(String city, String bedroom, String bathroom, String price, String type) {
        if (city == "") {
            city = "%%";
        }
        if (bedroom == "") {
            bedroom = "%%";
        }
        if (bathroom == "") {
            bathroom = "%%";
        }
        if (price == "") {
            price = "%%";
        }
        if (type == "") {
            type = "%%";
        }
        return houseRepository.search9House(city, bedroom, bathroom, price, type);
    }

}
