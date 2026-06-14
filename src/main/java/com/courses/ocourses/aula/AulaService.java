package com.courses.ocourses.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    AulaRepository aulaRepository;

    public Aula findById(Long id){
        return aulaRepository.findById(id).get();
    }

    public List<Aula> findAll(){
        return aulaRepository.findAll();
    }

    public void save(Aula aula){
        aulaRepository.save(aula);
    }




}
