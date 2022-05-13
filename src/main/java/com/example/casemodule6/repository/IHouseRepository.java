package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHouseRepository extends JpaRepository<House,Long> {

}
