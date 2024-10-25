package com.utp_example_1.demo_utp_1.controller;

import com.utp_example_1.demo_utp_1.service.EmpleadoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccesoController {

//    @Autowired
//    private EmpleadoService empleadoService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/login?logout";
    }
//    @GetMapping("/acceso")
//    public String mostrarFormularioAcceso() {
//        return "acceso"; // Nombre de la plantilla HTML (acceso.html)
//    }
//
//    @PostMapping("/acceso")
//    public String procesarAcceso(@RequestParam("correo") String correo,
//                                 @RequestParam("contraseña") String contraseña,
//                                 Model model) {
//        boolean autenticado = empleadoService.autenticarEmpleado(correo, contraseña);
//        if (autenticado) {
//            return "redirect:/envio/nuevo"; // Redirige a la página de inicio después de autenticarse
//        } else {
//            model.addAttribute("error", "Correo o contraseña incorrectos");
//            return "acceso"; // Vuelve a la página de acceso con un mensaje de error
//        }
//    }
}
