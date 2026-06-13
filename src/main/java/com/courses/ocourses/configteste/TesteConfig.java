package com.courses.ocourses.configteste;

import com.courses.ocourses.cursos.Curso;
import com.courses.ocourses.cursos.CursoService;
import com.courses.ocourses.usuario.Usuario;
import com.courses.ocourses.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    CursoService cursoService;

    @Override
    public void run(String... args) throws Exception {

    Usuario u1 = new Usuario(null, "vitor", "vitor@gmail.com", "123456789");

    usuarioService.save(u1);
    Curso c1 = new Curso(null, "Meu primeiro curso", "este curso blablabla", BigDecimal.valueOf(49.99), 150, u1);

    cursoService.save(c1);

    }
}
