package com.example.xmlproject.Model;

import java.util.ArrayList;

public class Filiere {

    private String idFiliere;
    private String FiliereLabel;
    private ArrayList<Etudiant> etudiants;
    private ArrayList<Professeur> professeurs;
    private ArrayList<Module> modules;
    private ArrayList<Note> notes;

    public Filiere() {}

    public Filiere(String idFiliere, String filiereLabel) {
        this.idFiliere = idFiliere;
        FiliereLabel = filiereLabel;
    }

    public Filiere(String idFiliere, String filiereLabel, ArrayList<Etudiant> etudiants, ArrayList<Professeur> professeurs,
                   ArrayList<Module> modules, ArrayList<Note> notes) {
        this.idFiliere = idFiliere;
        FiliereLabel = filiereLabel;
        this.etudiants = etudiants;
        this.professeurs = professeurs;
        this.modules = modules;
        this.notes = notes;
    }

    public String getIdFiliere() {
        return idFiliere;
    }

    public void setIdFiliere(String idFiliere) {
        this.idFiliere = idFiliere;
    }

    public String getFiliereLabel() {
        return FiliereLabel;
    }

    public void setFiliereLabel(String filiereLabel) {
        FiliereLabel = filiereLabel;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public ArrayList<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(ArrayList<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
}
