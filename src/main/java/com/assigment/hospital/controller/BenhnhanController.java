package com.assigment.hospital.controller;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.service.BenhnhanService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BenhnhanController {

    private final BenhnhanService service;

    public BenhnhanController(BenhnhanService service) {
        this.service = service;
    }

    @GetMapping("/tiepnhanbenhnhan")
    public String tiepNhanBenhNhan(Model model) {
        System.out.println("Vo Get roi");
        BenhnhanEntity benhNhan = service.tiepNhanBenhNhan();
        model.addAttribute("benhNhan", benhNhan);
        return "patient-infor";        
    }

    @PostMapping("/tiepnhanbenhnhan")
    public String luuBenhNhan(BenhnhanEntity benhNhan) {
        System.out.println("Vo day roi tiepnhanbenhnhan");
        service.luuBenhNhan(benhNhan);
        return "redirect:phieuxetnghiem";
    }
}