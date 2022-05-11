package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Type;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends PagingAndSortingRepository<Type, Long> {
}
