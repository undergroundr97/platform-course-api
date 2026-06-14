package com.courses.ocourses.aula;

import com.courses.ocourses.cursos.Curso;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "table_aulas")
public class Aula implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private Integer ordem;
    private String videoUrl;
    private Integer duracao;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Aula() {
    }

    public Aula(Long id, String titulo, Integer ordem, String videoUrl, Integer duracao, Curso curso) {
        Id = id;
        this.titulo = titulo;
        this.ordem = ordem;
        this.videoUrl = videoUrl;
        this.duracao = duracao;
        this.curso = curso;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return Objects.equals(Id, aula.Id) && Objects.equals(titulo, aula.titulo) && Objects.equals(ordem, aula.ordem) && Objects.equals(videoUrl, aula.videoUrl) && Objects.equals(duracao, aula.duracao) && Objects.equals(curso, aula.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, titulo, ordem, videoUrl, duracao, curso);
    }


}
