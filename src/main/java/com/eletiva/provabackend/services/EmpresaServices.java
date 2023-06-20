package com.eletiva.provabackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eletiva.provabackend.entities.Empresas;
import com.eletiva.provabackend.repositories.EmpresaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmpresaServices {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresas saveEmpresas(Empresas empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresas getEmpresaById(int id) {
        return empresaRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Erro ao encontrar empresa")
        );
    }

    public List<Empresas> getEmpresas() {
        return empresaRepository.findAll();
    }

    public void deleteEmpresa(int id) {
        Empresas empresa = getEmpresaById(id);
        empresaRepository.delete(empresa);
    }
    
}
