package com.courses.ocourses.usuario;

import com.courses.ocourses.matricula.Matricula;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "table_usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String email;
    private String password;

    @OneToMany
    private List<Matricula> matriculas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String password) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(Id, usuario.Id) && Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, nome, email, password);
    }


}
