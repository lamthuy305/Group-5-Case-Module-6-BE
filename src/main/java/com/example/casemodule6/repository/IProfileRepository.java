package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Profile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends PagingAndSortingRepository<Profile, Long> {

}
