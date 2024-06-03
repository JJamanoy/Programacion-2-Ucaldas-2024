package com.taller.taller.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.taller.taller.domain.Programa;

@Service
public class ProgramaServiceImp implements ProgramaService{
    private final ArrayList<Programa> programas = new ArrayList<>();
    
    @Override
    public ArrayList<Programa> listaProgramas(){
        if(programas == null)
            return new ArrayList<>();
        return programas;
    }

    @Override
    public void GuardarPrograma(Programa programa){
        programas.add(programa);
    }

    @Override
    public Programa mostrarPrograma (String name){
        return programas.stream().filter(programa -> programa.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
