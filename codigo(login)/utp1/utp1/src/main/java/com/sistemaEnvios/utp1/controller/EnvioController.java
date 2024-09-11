package com.sistemaEnvios.utp1.controller;

import com.sistemaEnvios.utp1.entity.Envio;
import com.sistemaEnvios.utp1.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1")
@Controller
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;

    @GetMapping("/envios")
    public String listarEnvios(Model model) {
        model.addAttribute("envios", envioRepository.findAll());
        return "envios";
    }

    @GetMapping("/envio/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("envio", new Envio());
        return "formularioEnvio";
    }

    @PostMapping("/envio/guardar")
    public String guardarEnvio(@ModelAttribute("envio") Envio envio) {
        envioRepository.save(envio);
        return "redirect:/envios";
    }
}
