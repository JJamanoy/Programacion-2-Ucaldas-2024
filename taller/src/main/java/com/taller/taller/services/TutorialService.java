package com.taller.taller.services;

import java.util.ArrayList;

import com.taller.taller.domain.Tutorial;

public interface TutorialService {
    ArrayList<Tutorial> listaTutoriales();
    void GuardarTutorial(Tutorial tutorial);
    Tutorial mostrarTutorial (Long id);
}
