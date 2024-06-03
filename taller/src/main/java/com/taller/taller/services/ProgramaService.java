package com.taller.taller.services;

import java.util.ArrayList;

import com.taller.taller.domain.Programa;

public interface ProgramaService {
    ArrayList<Programa> listaProgramas();
    void GuardarPrograma(Programa programa);
    Programa mostrarPrograma(String name);
}
