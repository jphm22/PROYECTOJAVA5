package com.utp_example_1.demo_utp_1.controller;

import com.utp_example_1.demo_utp_1.entity.Envio;
import com.utp_example_1.demo_utp_1.interfaces.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping ("/envio")
    public String listarEnvioS(Model model) {
        model.addAttribute("envios", envioRepository.findAll());
        return "envio";
    }
    @GetMapping ("/envio/nueva")
    public String mostrarEnvio(Model model) {
        model.addAttribute("envio", new Envio());
        return "formularioenvio";
    }
    @PostMapping("/envio/guardar")
    public String guardarEnvio(@ModelAttribute("envio") Envio envio) {
        envioRepository.save(envio);
        return "redirect:/envio";
    }
}
