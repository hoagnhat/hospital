package com.assigment.hospital.service;

import java.util.Optional;

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

    public PhieukhambenhEntity getById(long id) {
        Optional<PhieukhambenhEntity> optional = repository.findById(id);

        if (optional.isPresent()) {
            PhieukhambenhEntity phieukhambenh = optional.get();
            return phieukhambenh;
        }
        return null;
    }

    public PhieukhambenhEntity getByMabn(long mabn) {
        return repository.findByMabn(mabn);
    }

}
