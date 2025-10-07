package com.example.musica.aplicacion.service;

import com.example.musica.aplicacion.config.JwtService;
import com.example.musica.infraestructura.model.Usuario;
import com.example.musica.infraestructura.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(String username, String password, String nombre, String rol) {
        Usuario usuario = Usuario.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .nombre(nombre)
                .rol(rol)
                .build();
        usuarioRepository.save(usuario);
        return jwtService.generateToken(username);
    }

    public String login(String username, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);
        if (usuarioOpt.isPresent() && passwordEncoder.matches(password, usuarioOpt.get().getPassword())) {
            return jwtService.generateToken(username);
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}
