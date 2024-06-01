package com.taller.taller.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.taller.taller.domain.Tutorial;

@Service
public class TutorialServiceImp implements TutorialService{
    private final ArrayList<Tutorial> tutoriales = new ArrayList<>();

    @Override
    public ArrayList<Tutorial> listaTutoriales(){
        if(tutoriales == null)
            return new ArrayList<>();
        return tutoriales;
    }

    @Override
    public void GuardarTutorial(Tutorial tutorial){
        tutoriales.add(tutorial);
    }

    @Override
    public Tutorial mostrarTutorial(String name){
        return tutoriales.stream().filter(tutorial -> tutorial.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
