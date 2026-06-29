package com.courses.ocourses.dashboard;

import com.courses.ocourses.security.JwtService;
import com.courses.ocourses.usuario.Usuario;
import com.courses.ocourses.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashboardService {
    @Autowired
    UsuarioService usuarioService;


    public DashboardDTO transformToDashboardDTO(String email){
        Usuario usuario = usuarioService.findByEmail(email).get();
        return new DashboardDTO(usuario);
    }


}
