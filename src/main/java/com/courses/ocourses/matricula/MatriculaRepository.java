package com.courses.ocourses.matricula;

import com.courses.ocourses.matricula.matriculaPK.MatriculaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {
}
