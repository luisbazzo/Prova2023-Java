package com.eletiva.provabackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eletiva.provabackend.entities.Empresas;

public interface EmpresaRepository extends JpaRepository <Empresas, Integer>{
    
}
