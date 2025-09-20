package com.example.spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class endpoints {

    @GetMapping("/teste")
    public String teste() {
        System.out.println("Endpoint /teste foi chamado!");
        return "Check no console!";
    }
}
