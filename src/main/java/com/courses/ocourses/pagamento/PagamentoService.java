package com.courses.ocourses.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;


    public Pagamento findById(Long id){
        return pagamentoRepository.findById(id).get();
    }

    public List<Pagamento> findAll(){
        return pagamentoRepository.findAll();
    }

    public void save(Pagamento pagamento){
        pagamentoRepository.save(pagamento);
    }

    public void realizarPagamento(Pagamento pagamento){
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamentoRepository.save(pagamento);
    }



}
