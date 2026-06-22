package com.courses.ocourses.usuario;


import jakarta.servlet.Servlet;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "localhost:4200")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok().body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(usuarioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
        Usuario user = usuarioService.findById(usuario.getId());

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(user.getId())
                .toUri();

        return  ResponseEntity.created(uri).body(user);
    }



}


