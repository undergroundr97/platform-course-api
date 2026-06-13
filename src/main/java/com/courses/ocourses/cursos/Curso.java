package com.courses.ocourses.cursos;

import com.courses.ocourses.usuario.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "table_cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Usuario instrutor;



    public Curso() {
    }

    public Curso(Long id, String titulo, String descricao, BigDecimal preco, Integer cargaHoraria, Usuario instrutor) {
        Id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.cargaHoraria = cargaHoraria;
        this.instrutor = instrutor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Curso cursos = (Curso) o;
        return Objects.equals(Id, cursos.Id) && Objects.equals(titulo, cursos.titulo) && Objects.equals(descricao, cursos.descricao) && Objects.equals(preco, cursos.preco) && Objects.equals(cargaHoraria, cursos.cargaHoraria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, titulo, descricao, preco, cargaHoraria);
    }
}
