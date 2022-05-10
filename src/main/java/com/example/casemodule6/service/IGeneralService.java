package com.example.casemodule6.service;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    Optional<T> findById(Long id);

    T save(T t);

    void removeById(Long id);
}
