package com.assigment.hospital.service;

import com.assigment.hospital.entity.KhoaEntity;
import com.assigment.hospital.entity.NhanvienEntity;
import com.assigment.hospital.entity.TaikhoanEntity;
import com.assigment.hospital.repository.KHOARepository;
import com.assigment.hospital.repository.NhanvienRepository;
import com.assigment.hospital.repository.TaiKhoanRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TaiKhoanService {

    private final KHOARepository khoaRepository;
    private final NhanvienRepository nhanvienRepository;

    private final PasswordEncoder passwordEncoder;
    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanService(KHOARepository khoaRepository, NhanvienRepository nhanvienRepository, PasswordEncoder passwordEncoder, TaiKhoanRepository taiKhoanRepository) {
        this.khoaRepository = khoaRepository;
        this.nhanvienRepository = nhanvienRepository;
        this.passwordEncoder = passwordEncoder;
        this.taiKhoanRepository = taiKhoanRepository;
    }


    public String danky(TaikhoanEntity taikhoanEntity) {
        System.out.println("Alo");
        if (taiKhoanRepository.findTaikhoanEntityByUsername(taikhoanEntity.getUsername()).isPresent()) {
            System.out.println("Vo me if roi");
            return "redirect:404";
        }

        //TODO DUMMY KHOA AND NHAN VIEN TO TEST
        KhoaEntity khoa = new KhoaEntity();
        khoa.setTenKhoa("ABC");
        khoa = khoaRepository.saveAndFlush(khoa);

        NhanvienEntity nhanvien = new NhanvienEntity();
        nhanvien.setHoten("abc");
        nhanvien.setKhoaByMakhoa(khoa);
        nhanvien = nhanvienRepository.saveAndFlush(nhanvien);

        taikhoanEntity.setNhanvienByManv(nhanvien);
        taikhoanEntity.setPassword(passwordEncoder.encode(taikhoanEntity.getPassword()));
        taikhoanEntity.setManv(nhanvien.getManv());
        taiKhoanRepository.saveAndFlush(taikhoanEntity);



        return "redirect:index";
    }
}
