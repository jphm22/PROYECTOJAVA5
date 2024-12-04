package com.utp_example_1.demo_utp_1.interfaces;

import com.utp_example_1.demo_utp_1.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Empleado findByCorreoAndContraseña(String correo, String contraseña);
    /*Empleado findByCorreo(String correo);*/
}

