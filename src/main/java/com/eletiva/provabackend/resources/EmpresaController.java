package com.eletiva.provabackend.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eletiva.provabackend.entities.Empresas;
import com.eletiva.provabackend.services.EmpresaServices;

@RestController
@RequestMapping("empresas")
@CrossOrigin
public class EmpresaController {
    
    @Autowired
    private EmpresaServices empresaServices;

    @PostMapping
    public ResponseEntity<Empresas> saveEmpresa(@RequestBody Empresas empresa){
        Empresas novaEmpresa = empresaServices.saveEmpresas(empresa);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(empresa.getId())
            .toUri();

        return ResponseEntity.created(location).body(novaEmpresa);
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresas> getEmpresa(@PathVariable int id){
        Empresas empresa = empresaServices.getEmpresaById(id);
        return ResponseEntity.ok().body(empresa);
    }

    @GetMapping
    public ResponseEntity<List<Empresas>> getEmpresas(){
        List<Empresas> empresas = empresaServices.getEmpresas();
        return ResponseEntity.ok().body(empresas);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable int id){
        empresaServices.deleteEmpresa(id);
        return ResponseEntity.ok().build();
    }

}
