package com.assigment.hospital.repository;

import com.assigment.hospital.entity.BenhnhanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenhnhanRepository extends JpaRepository<BenhnhanEntity, Long> {

}
