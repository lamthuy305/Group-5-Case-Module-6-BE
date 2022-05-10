package com.example.casemodule6.service;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void deleteById(Long id);
}
