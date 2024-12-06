package com.utp_example_1.demo_utp_1.seguridad;


//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {/*
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/**") // Configura el patrón de URL general
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/acceso", "envio/nuevo","/Imagenes/**").permitAll() // Permitir acceso público
                        .anyRequest().authenticated() // Proteger las demás rutas
                )
                .formLogin(login -> login
                        .loginPage("/acceso") // Ruta personalizada para el login
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );



        return http.build();
    }*/
}
