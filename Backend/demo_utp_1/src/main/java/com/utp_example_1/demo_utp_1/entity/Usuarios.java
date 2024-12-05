package com.utp_example_1.demo_utp_1.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "users")
    @AllArgsConstructor
    @NoArgsConstructor
    @Data

    public class Usuarios {

        @Id
        @GeneratedValue
        private Long id;
        private String username;
        private String password;
        private String role;
    }


