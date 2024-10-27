package com.jamessipac.kataWeather.service;

import com.jamessipac.kataWeather.model.Usuario;
import com.jamessipac.kataWeather.repository.usuario.UsuarioRepository;
import com.jamessipac.kataWeather.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(String email, String password) {
        // Validar si el email o la contraseña son nulos
        if (email == null || password == null) {
            throw new RuntimeException("Invalid credentials");
        }

        System.out.println(email);
        System.out.println(password);

        Usuario usuario = usuarioRepository.findByEmail(email);
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getPassword());

        if (usuario != null && passwordEncoder.matches(password, usuario.getPassword())) {
            System.out.println(usuario);
            return jwtTokenUtil.generateToken(usuario.getId());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

}
