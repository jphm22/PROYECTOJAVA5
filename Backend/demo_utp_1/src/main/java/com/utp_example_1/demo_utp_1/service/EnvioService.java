package com.utp_example_1.demo_utp_1.service;

import com.utp_example_1.demo_utp_1.interfaces.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public void eliminarEnvio(Long id) {
        envioRepository.deleteById(id); // Elimina el envio usando el repositorio
    }

}
