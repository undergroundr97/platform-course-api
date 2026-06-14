package com.courses.ocourses.matricula;

import com.courses.ocourses.matricula.matriculaPK.MatriculaPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    public Matricula findById(MatriculaPK id){
        return matriculaRepository.findById(id).get();
    }

    public List<Matricula> findAll(){
        return matriculaRepository.findAll();
    }

    public void save(Matricula matricula){
        matriculaRepository.save(matricula);
    }


}
