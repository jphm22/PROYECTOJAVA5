package com.utp_example_1.demo_utp_1.service.impl;


import com.utp_example_1.demo_utp_1.entity.SecurityUser;
import com.utp_example_1.demo_utp_1.entity.Usuarios;
import com.utp_example_1.demo_utp_1.interfaces.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new SecurityUser(user);

    }
}
