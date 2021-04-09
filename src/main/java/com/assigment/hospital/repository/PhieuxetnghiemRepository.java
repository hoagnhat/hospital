package com.assigment.hospital.repository;

import com.assigment.hospital.entity.PhieuxetnghiemEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuxetnghiemRepository extends JpaRepository<PhieuxetnghiemEntity, Long> {
    
}
