package com.example.casemodule6.repository;

import com.example.casemodule6.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFileRepository extends JpaRepository<Image,Long> {
}
