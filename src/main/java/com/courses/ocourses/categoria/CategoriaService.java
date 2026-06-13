package com.courses.ocourses.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).get();
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public void save(Categoria categoria){
        categoriaRepository.save(categoria);
    }

}
