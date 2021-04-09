package com.assigment.hospital.controller;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.entity.PhieukhambenhEntity;
import com.assigment.hospital.service.BenhnhanService;
import com.assigment.hospital.service.PhieukhambenhService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhieukhambenhController {
    
    private final PhieukhambenhService service;
    private final BenhnhanService benhnhanService;

    public PhieukhambenhController(PhieukhambenhService service, BenhnhanService benhNhanService) {
        this.service = service;
        this.benhnhanService = benhNhanService;
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
        phieukhambenh.setBenhnhanByMabn(benhNhan);
        service.luuPhieuKhamBenh(phieukhambenh);
        return "formkhambenh";
    }

}
