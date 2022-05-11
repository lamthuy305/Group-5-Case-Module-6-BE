package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<Role, Long> {
}
