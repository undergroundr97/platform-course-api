package com.courses.ocourses.login;

import java.util.Objects;

public class Login {

    public String email;
    public String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Login() {
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
        Login login = (Login) o;
        return Objects.equals(email, login.email) && Objects.equals(password, login.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
