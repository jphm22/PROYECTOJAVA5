package com.utp_example_1.demo_utp_1.service;

import com.utp_example_1.demo_utp_1.entity.Empleado;
import com.utp_example_1.demo_utp_1.interfaces.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public boolean autenticarEmpleado(String correo, String contraseña) {
        Empleado empleado = empleadoRepository.findByCorreoAndContraseña(correo, contraseña);
        return empleado != null;
    }
}
