package com.utp_example_1.demo_utp_1.service;

import com.utp_example_1.demo_utp_1.entity.Empleado;
import com.utp_example_1.demo_utp_1.entity.Sesion;
import com.utp_example_1.demo_utp_1.interfaces.EmpleadoRepository;
import com.utp_example_1.demo_utp_1.interfaces.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmpleadoService {


    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private SesionRepository sesionRepository;

    public boolean autenticarEmpleado(String correo, String contraseña) {
        Empleado empleado = empleadoRepository.findByCorreoAndContraseña(correo, contraseña);
        if (empleado != null) {
            // Si la autenticación es correcta, registramos la sesión
            Sesion sesion = new Sesion();
            sesion.setEmpleado(empleado);
            sesion.setInicioSesion(LocalDateTime.now());
            sesionRepository.save(sesion);
            return true;
        }
        return false;

    }
}
 /*@Autowired
    private EmpleadoRepository empleadoRepository;

    public boolean autenticarEmpleado(String correo, String contraseña) {
        Empleado empleado = empleadoRepository.findByCorreoAndContraseña(correo, contraseña);
        return empleado != null;
    }*/