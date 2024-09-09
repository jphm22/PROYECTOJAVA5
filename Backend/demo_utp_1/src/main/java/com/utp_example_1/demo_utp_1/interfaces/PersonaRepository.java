package com.utp_example_1.demo_utp_1.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp_example_1.demo_utp_1.entity.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, Long>{

}
