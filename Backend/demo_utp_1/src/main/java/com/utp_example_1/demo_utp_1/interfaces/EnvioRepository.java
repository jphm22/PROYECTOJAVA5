package com.utp_example_1.demo_utp_1.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.utp_example_1.demo_utp_1.entity.Envio;

import java.util.List;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
    Envio findByDniRemitente(String dniRemitente);
    //List<Envio> findByDniRemitente(String dniRemitente); // buscar por DNI
    Page<Envio> findByDniRemitente(String dni, Pageable pageable);
}

