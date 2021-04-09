package com.assigment.hospital.service;

import com.assigment.hospital.entity.PhieukhambenhEntity;
import com.assigment.hospital.repository.PhieukhambenhRepository;

import org.springframework.stereotype.Service;

@Service
public class PhieukhambenhService {
    
    private final PhieukhambenhRepository repository;

    public PhieukhambenhService(PhieukhambenhRepository repository) {
        this.repository = repository;
    }

    public void luuPhieuKhamBenh(PhieukhambenhEntity phieukhambenh) {
        repository.saveAndFlush(phieukhambenh);
    }

}
