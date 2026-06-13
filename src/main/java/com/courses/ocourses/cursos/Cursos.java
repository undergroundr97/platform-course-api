package com.courses.ocourses.cursos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_cursos")
public class Cursos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private Integer cargaHoraria;


    public Cursos() {
    }

    public Cursos(Long id, String titulo, String descricao, BigDecimal preco, Integer cargaHoraria) {
        Id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.cargaHoraria = cargaHoraria;
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
        Cursos cursos = (Cursos) o;
        return Objects.equals(Id, cursos.Id) && Objects.equals(titulo, cursos.titulo) && Objects.equals(descricao, cursos.descricao) && Objects.equals(preco, cursos.preco) && Objects.equals(cargaHoraria, cursos.cargaHoraria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, titulo, descricao, preco, cargaHoraria);
    }
}
