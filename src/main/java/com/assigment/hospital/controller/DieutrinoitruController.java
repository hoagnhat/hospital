package com.assigment.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DieutrinoitruController {
    @GetMapping("/dieutrinoitru")
    public String dieutrinoitru() {
        return "dieutrinoitru";
    }
}
