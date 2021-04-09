package com.assigment.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageController {
    @GetMapping("/")
    public String showMainPage() {
        return "main-page";
    }
}
