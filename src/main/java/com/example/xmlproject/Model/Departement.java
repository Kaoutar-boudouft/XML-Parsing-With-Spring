package com.example.xmlproject.Model;

import java.util.ArrayList;

public class Departement {
    private String idDep;

    private String nomDepartement;
    private ArrayList<Filiere> filieres;

    public Departement(){}

    public Departement(String idDep,String nomDepartement){
        this.nomDepartement = nomDepartement;
        this.idDep = idDep;
    }
    public Departement(String idDep,String nomDepartement,ArrayList<Filiere> filieres){
        this.nomDepartement = nomDepartement;
        this.filieres = filieres;
        this.idDep = idDep;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }

    public String getIdDep() {
        return idDep;
    }

    public void setIdDep(String idDep) {
        this.idDep = idDep;
    }
}
