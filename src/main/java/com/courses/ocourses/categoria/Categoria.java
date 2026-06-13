package com.courses.ocourses.categoria;

import com.courses.ocourses.cursos.Curso;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "table_categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Curso> listaCursosComCategoria = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long id, String nome, String descricao) {
        Id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(Id, categoria.Id) && Objects.equals(nome, categoria.nome) && Objects.equals(descricao, categoria.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, descricao);
    }


}
