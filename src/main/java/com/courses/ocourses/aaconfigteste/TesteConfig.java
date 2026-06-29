package com.courses.ocourses.aaconfigteste;

import com.courses.ocourses.aula.Aula;
import com.courses.ocourses.aula.AulaService;
import com.courses.ocourses.categoria.Categoria;
import com.courses.ocourses.categoria.CategoriaService;
import com.courses.ocourses.cursos.Curso;
import com.courses.ocourses.cursos.CursoService;
import com.courses.ocourses.matricula.Matricula;
import com.courses.ocourses.matricula.MatriculaService;
import com.courses.ocourses.pagamento.MetodoPagamento;
import com.courses.ocourses.pagamento.Pagamento;
import com.courses.ocourses.pagamento.PagamentoService;
import com.courses.ocourses.usuario.Usuario;
import com.courses.ocourses.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    CursoService cursoService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    AulaService aulaService;

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    PagamentoService pagamentoService;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "vitor","emanuel" ,"vitor@gmail.com", "123456789");

        Usuario aluno1 = new Usuario(null, "pedro", "emanuel", "pedro@gmail.com", "123456789");
        usuarioService.save(u1);
        usuarioService.save(aluno1);
        Usuario vitor = new Usuario(null, "vitor1", "emanuel", "vitor_@gmail.com", "123456789" );
        usuarioService.save(vitor);

        Curso c1 = new Curso(null, "Meu primeiro curso", "este curso blablabla", BigDecimal.valueOf(49.99), 150, u1);
        Categoria cat1 = new Categoria(null, "Jogos", "Minha nova cateogira");
        c1.setCategoria(cat1);

        Aula a1 = new Aula(null,"Primeira aula", 1,"viodeoURL/path", 500, c1);

        categoriaService.save(cat1);
        cursoService.save(c1);
        c1.getAulas().add(a1);
        aulaService.save(a1);
        cursoService.save(c1);


        Matricula m1 = new Matricula(aluno1,c1);
        matriculaService.cadastrarAlunoNoCurso(m1);
        matriculaService.save(m1);

        Pagamento p1 = new Pagamento(null, LocalDateTime.now(), Double.valueOf(String.valueOf(c1.getPreco())), MetodoPagamento.PIX, m1);

        pagamentoService.save(p1);

        pagamentoService.realizarPagamento(p1);


//        UserDetailsService

    }
}
