package com.courses.ocourses.login;


import com.courses.ocourses.usuario.Usuario;
import com.courses.ocourses.usuario.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<Void> checkLogin(@RequestBody Login login){
        Optional<Usuario> checkUsuario = usuarioService.findByEmail(login.getEmail());

        if(checkUsuario.isPresent()){
            Usuario user = checkUsuario.get();
            if(passwordEncoder.matches(login.getPassword(), user.getPassword())){
                return ResponseEntity.ok().build();
            }
        }

        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }


}
