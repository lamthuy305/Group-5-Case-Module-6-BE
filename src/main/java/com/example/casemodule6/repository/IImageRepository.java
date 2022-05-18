package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Image;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends PagingAndSortingRepository<Image, Long> {

    @Query(value = "select * from images i join houses h on h.id = i.house_id where house_id = ?1", nativeQuery = true)
    Iterable<Image> findAllImageByHouseId(Long id);

}
