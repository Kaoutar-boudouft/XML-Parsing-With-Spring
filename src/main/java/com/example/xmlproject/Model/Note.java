package com.example.xmlproject.Model;

public class Note {

    private String ModuleRef,EtudiantRef;
    private float valeur;

    public Note() {}

    public Note(String moduleRef, String etudiantRef, float valeur) {
        ModuleRef = moduleRef;
        EtudiantRef = etudiantRef;
        this.valeur = valeur;
    }

    public String getModuleRef() {
        return ModuleRef;
    }

    public void setModuleRef(String moduleRef) {
        ModuleRef = moduleRef;
    }

    public String getEtudiantRef() {
        return EtudiantRef;
    }

    public void setEtudiantRef(String etudiantRef) {
        EtudiantRef = etudiantRef;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }
}
