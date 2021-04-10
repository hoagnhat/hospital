package com.assigment.hospital.repository;

import com.assigment.hospital.entity.KhoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KHOARepository extends JpaRepository<KhoaEntity, Long> {

}
