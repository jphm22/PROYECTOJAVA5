package com.utp_example_1.demo_utp_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp_example_1.demo_utp_1.entity.Persona;
import com.utp_example_1.demo_utp_1.interfaces.PersonaRepository;

@Controller
public class PersonaController {

	  @Autowired
	  private PersonaRepository personaRepository;

	  @GetMapping("/personas")
	    public String listarPersonas(Model model) {
	        model.addAttribute("personas", personaRepository.findAll());
	        return "personas";
	    }
	  
	  @GetMapping("/persona/nueva")
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("persona", new Persona());
	        return "formulario";
	    }
	  
	  @PostMapping("/persona/guardar")
	    public String guardarPersona(@ModelAttribute("persona") Persona persona) {
	        personaRepository.save(persona);
	        return "redirect:/personas";
	    }
	  
	  
}
