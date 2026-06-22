package com.courses.ocourses.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Usuario findById(Long id){
        return usuarioRepository.findById(id).get();
    }

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public void save(Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    public Optional<Usuario> findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }



}
