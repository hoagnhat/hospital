package com.assigment.hospital.service;

import java.util.Optional;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.repository.BenhnhanRepository;

import org.springframework.stereotype.Service;

@Service
public class BenhnhanService {
    
    private final BenhnhanRepository repository;

    public BenhnhanService(BenhnhanRepository repository) {
        this.repository = repository;
    }
    
    public BenhnhanEntity tiepNhanBenhNhan() {
        BenhnhanEntity benhNhan = new BenhnhanEntity();
        benhNhan = repository.saveAndFlush(benhNhan);
        return benhNhan;
    }

    public void luuBenhNhan(BenhnhanEntity benhNhan) {
        repository.saveAndFlush(benhNhan);
    }

    public BenhnhanEntity getById(long maBn) {
        Optional<BenhnhanEntity> optional = repository.findById(maBn);
        if (optional.isPresent()) {
            BenhnhanEntity benhNhan = optional.get();
            return benhNhan;
        }
        return null;
    }
}