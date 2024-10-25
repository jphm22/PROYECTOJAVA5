package com.utp_example_1.demo_utp_1.interfaces;

import com.utp_example_1.demo_utp_1.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuarios, Long> {
    Usuarios findByUsername(String username);
}
