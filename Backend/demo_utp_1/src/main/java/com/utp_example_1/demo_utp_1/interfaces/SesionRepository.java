package com.utp_example_1.demo_utp_1.interfaces;

import com.utp_example_1.demo_utp_1.entity.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {
}
