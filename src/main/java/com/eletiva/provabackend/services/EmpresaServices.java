package com.eletiva.provabackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eletiva.provabackend.entities.Empresas;
import com.eletiva.provabackend.repositories.EmpresaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaServices {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresas getEmpresaById(int id) {
        return empresaRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Erro ao encontrar empresa")
        );
    }

    public Empresas saveEmpresas(Empresas empresa) {
        return empresaRepository.save(empresa);
    }
    
}
