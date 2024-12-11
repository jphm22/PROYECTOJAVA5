package com.utp_example_1.demo_utp_1.controller;

import com.utp_example_1.demo_utp_1.dto.EnvioDto;
import com.utp_example_1.demo_utp_1.entity.Auditoria;
import com.utp_example_1.demo_utp_1.interfaces.AuditoriaRepository;
import com.utp_example_1.demo_utp_1.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.utp_example_1.demo_utp_1.entity.Envio;
import com.utp_example_1.demo_utp_1.interfaces.EnvioRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Optional;

@Controller
public class EnvioController {

    @Autowired
    private EnvioRepository envioRepository;
    @Autowired
    private AuditoriaRepository auditoriaRepository;
    @Autowired
    private EnvioService envioService;


    /*@GetMapping("/envios")
    public String listarEnvios(Model model) {
        model.addAttribute("envios", envioRepository.findAll());
        return "envios";
    }*/
    /*@GetMapping("/envios")
    public String listarEnvios(@RequestParam(value = "dni", required = false) String dni, Model model) {
        if (dni != null && !dni.isEmpty()) {
            model.addAttribute("envios", envioRepository.findByDniRemitente(dni)); //filtrarporDNI
        } else {
            model.addAttribute("envios", envioRepository.findAll());
        }
        model.addAttribute("dni", dni);
        return "envios";
    }*/

    // Nuevo endpoint para obtener los datos de peso y volumen según el DNI
    @GetMapping("/envio/datosPorDni")
    @ResponseBody
    public EnvioDto obtenerDatosPorDni(@RequestParam("dni") String dni) {
        Envio envio = envioRepository.findByDniRemitente(dni); //buscar por DNI
        if (envio != null) {
            EnvioDto envioDto = new EnvioDto();
            envioDto.setPeso(envio.getPeso());
            envioDto.setVolumen(envio.getVolumen());
            return envioDto; // Devolvemos los datos en formato JSON
        }
        return null; // Si no se encuentra, devolvemos null
    }

    @GetMapping("/envios")
    public String listarEnvios(
            @RequestParam(value = "dni", required = false) String dni,
            @RequestParam(value = "page", defaultValue = "0") int page,
            Model model) {

        int pageSize = 5; // Filas por página
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Envio> envios;

        if (dni != null && !dni.isEmpty()) {
            envios = envioRepository.findByDniRemitente(dni, pageable); // Ajusta tu repositorio si es necesario
        } else {
            envios = envioRepository.findAll(pageable);
        }

        model.addAttribute("envios", envios);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", envios.getTotalPages());
        model.addAttribute("dni", dni);
        return "envios";
    }


    @GetMapping("/envio/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("envio", new Envio());
        return "formularioEnvio";
    }   

    @PostMapping("/envio/guardar")
    public String guardarEnvio(@ModelAttribute("envio") EnvioDto envio) throws UnknownHostException {

        InetAddress ip = InetAddress.getLocalHost();
        String usuario = System.getProperty("user.name");

        Envio nuevo_envio = new Envio();
        Auditoria auditoria = new Auditoria();
        nuevo_envio.setIdEnvio(envio.getIdEnvio());
        nuevo_envio.setNombreRemitente(envio.getNombreRemitente());
        nuevo_envio.setDniRemitente(envio.getDniRemitente());
        nuevo_envio.setPeso(envio.getPeso());
        nuevo_envio.setVolumen(envio.getVolumen());
        nuevo_envio.setLugarEnvio(envio.getLugarEnvio());
        nuevo_envio.setLugarDestino(envio.getLugarDestino());
        envioRepository.save(nuevo_envio);

        auditoria.setUsuario(usuario);
        auditoria.setIp_maquina(ip.getHostAddress()); // Obtener la IP como String
        auditoria.setIdpersona(nuevo_envio.getIdEnvio());
        auditoriaRepository.save(auditoria);

        return "redirect:/envios";
    }

    @GetMapping("/envio/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {

        Optional<Envio> envioOpt = envioRepository.findById(id);
        if (envioOpt.isPresent()) {
            model.addAttribute("envio", envioOpt.get());
            return "formularioEnvio";
        } else {
            return "redirect:/envios"; // Redirige al listado si no se encuentra la persona
        }

    }


    @PostMapping("/envio/eliminar/{id}")
    public String eliminarEnvio(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        envioService.eliminarEnvio(id); // Llamada al servicio para eliminar
        redirectAttributes.addFlashAttribute("mensaje", "Envio eliminado exitosamente");
        return "redirect:/envios"; // Redireccionar al listado de personas
    }

   /* @GetMapping("/acceso")
    public String mostraracceso(Model model) {
        model.addAttribute("acceso", envioRepository.findAll());
        return "acceso";
    }*/

    @GetMapping("/confirmacion")
    public String mostrarconfirmacion(Model model) {
        model.addAttribute("confirmacion", envioRepository.findAll());
        return "confirmacion";
    }

    @GetMapping(value="/pdf/{id}")
    public HttpEntity<byte[]> generarreporte (@PathVariable(value="id") Long id) throws SQLException {


        System.out.println(id);


        byte[] documentBody = envioService.generarpdf(id);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "documento.pdf");
        header.setContentLength(documentBody.length);

        return new HttpEntity<byte[]>(documentBody, header);
    }
}
