package com.assigment.hospital.controller;

import com.assigment.hospital.entity.TaikhoanEntity;
import com.assigment.hospital.service.TaiKhoanService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private final TaiKhoanService taiKhoanService;

    public AppController(TaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    @GetMapping("/")
    public String rootURL(Authentication authResult) {
        return common(authResult);
    }

    @GetMapping("/index")
    public String index(Authentication authResult) {
        return common(authResult);
    }

    @GetMapping("/login")
    public String login(Authentication authResult) {
        if (authResult==null) {
            return "login";
        }
        return "redirect:index";
    }

    @GetMapping("/dangki")
    public String dangki(@ModelAttribute("TaiKhoan")TaikhoanEntity taikhoanEntity, Model model) {
        model.addAttribute("TaiKhoan", new TaikhoanEntity());
        return "dangki";
    }

    @PostMapping("/dangki")
    public String dangkipost(@ModelAttribute("TaiKhoan")TaikhoanEntity taikhoanEntity, Model model) {
        model.addAttribute("TaiKhoan", taikhoanEntity);
        System.out.println("Post chay vao roi");
        return taiKhoanService.danky(taikhoanEntity);
    }

    private String common(Authentication authResult) {
        String url = "index";
        if (authResult != null) {
            url = "main-page";
        }
        return url;
    }
}
