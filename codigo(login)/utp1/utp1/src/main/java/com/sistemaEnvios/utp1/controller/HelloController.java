package com.sistemaEnvios.utp1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('ADMIN')")

    public String hello() {
        return "hello";
    }
}
