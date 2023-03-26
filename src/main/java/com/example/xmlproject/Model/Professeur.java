package com.example.xmlproject.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Professeur {

    private String idProf,nom,prenom,resVille,lieuN;
    private ArrayList<String> emails, Telephones;
    private float salaire;
    private LocalDate DOB;

    public Professeur() {}

    public Professeur(String idProf, String nom, String prenom, String resVille, String lieuN,LocalDate DOB,
                      ArrayList<String> emails, ArrayList<String> telephones, float salaire) {
        this.idProf = idProf;
        this.nom = nom;
        this.prenom = prenom;
        this.resVille = resVille;
        this.lieuN = lieuN;
        this.DOB = DOB;
        this.emails = emails;
        Telephones = telephones;
        this.salaire = salaire;
    }

    public String getIdProf() {
        return idProf;
    }

    public void setIdProf(String idProf) {
        this.idProf = idProf;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getResVille() {
        return resVille;
    }

    public void setResVille(String resVille) {
        this.resVille = resVille;
    }

    public String getLieuN() {
        return lieuN;
    }

    public void setLieuN(String lieuN) {
        this.lieuN = lieuN;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getTelephones() {
        return Telephones;
    }

    public void setTelephones(ArrayList<String> telephones) {
        Telephones = telephones;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
}
