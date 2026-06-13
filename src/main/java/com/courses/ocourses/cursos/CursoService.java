package com.courses.ocourses.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    CursoRepository cursoRepository;

    public Curso findById(Long id){
        return cursoRepository.findById(id).get();
    }

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public void save(Curso curso){
        cursoRepository.save(curso);
    }


}
