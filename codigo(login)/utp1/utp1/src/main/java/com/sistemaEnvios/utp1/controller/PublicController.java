package com.sistemaEnvios.utp1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
//ya no va
public class PublicController {

        @GetMapping("/home")
        public String home() {
            return "Public Home";
        }


}
