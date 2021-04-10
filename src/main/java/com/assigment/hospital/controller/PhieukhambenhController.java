package com.assigment.hospital.controller;

import java.sql.Date;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.entity.NhanvienEntity;
import com.assigment.hospital.entity.PhieukhambenhEntity;
import com.assigment.hospital.service.BenhnhanService;
import com.assigment.hospital.service.NhanvienService;
import com.assigment.hospital.service.PhieukhambenhService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhieukhambenhController {
    
    private final PhieukhambenhService service;
    private final NhanvienService nhanvienService;
    private final BenhnhanService benhnhanService;

    public PhieukhambenhController(PhieukhambenhService service, 
                                   BenhnhanService benhNhanService, 
                                   NhanvienService nhanvienService) {
        this.service = service;
        this.benhnhanService = benhNhanService;
        this.nhanvienService = nhanvienService;
    }

    @GetMapping("/phieukhambenh")
    public String redirectToFormNhapMaBN() {
        return "formkhambenh";
    }

    @PostMapping("/phieukhambenh")
    public String showPhieukhambenh(@RequestParam("mabn") long mabn, Model model) {
        BenhnhanEntity benhNhan = benhnhanService.getById(mabn);
        if (benhNhan == null) {
            return "404";
        }
        model.addAttribute("benhNhan", benhNhan);
        if (benhNhan.getGioiTinh()) {
            model.addAttribute("gioitinh", "Nam");
        } else {
            model.addAttribute("gioitinh", "Nữ");
        }
        return "quanlykhambenh";
    }

    @PostMapping("/khambenh")
    public String khamBenh(@RequestParam("mabn") long mabn, PhieukhambenhEntity phieukhambenh) {
        BenhnhanEntity benhNhan = benhnhanService.getById(mabn);

        // TODO: Need to change with Current User
        NhanvienEntity nhanVien = nhanvienService.getById(1);
        // Set name for bac si chi dinh
        phieukhambenh.setManv(nhanVien.getManv());

        phieukhambenh.setBenhnhanByMabn(benhNhan);
        long millis=System.currentTimeMillis();
        Date ngaychidinh = new Date(millis);
        phieukhambenh.setNgaychidinh(ngaychidinh);
        service.luuPhieuKhamBenh(phieukhambenh);
        return "formkhambenh";
    }

}
